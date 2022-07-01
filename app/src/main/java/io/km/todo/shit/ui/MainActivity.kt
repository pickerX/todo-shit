package io.km.todo.shit.ui

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.platform.ComposeView
import androidx.core.view.WindowCompat
import androidx.navigation.findNavController
import io.km.todo.base.BackPressHandler
import io.km.todo.base.LocalBackPressedDispatcher
import io.km.todo.shit.R
import io.km.todo.shit.module.todo.TodoViewModel
import io.km.todo.shit.theme.TodoTheme
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private val viewModel: TodoViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Turn off the decor fitting system windows, which allows us to handle insets,
        // including IME animations
        WindowCompat.setDecorFitsSystemWindows(window, false)

        setContent {
            ComposeView(this).apply { setContent { TodoScreen(this) } }
        }
    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    private fun TodoScreen(compose: ComposeView) {
        CompositionLocalProvider(LocalBackPressedDispatcher provides onBackPressedDispatcher) {
            val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)

            val drawerOpen by viewModel.drawerShouldBeOpened.collectAsState()
            if (drawerOpen) {
                // Open drawer and reset state in VM.
                LaunchedEffect(Unit) {
                    drawerState.open()
                    viewModel.resetOpenDrawerAction()
                }
            }

            // Intercepts back navigation when the drawer is open
            val scope = rememberCoroutineScope()
            if (drawerState.isOpen) {
                BackPressHandler {
                    scope.launch { drawerState.close() }
                }
            }

            TodoScaffold(
                drawerState = drawerState,
                onDrawItemClicked = {
                    compose.findNavController().popBackStack(R.id.nav_home, false)
                    scope.launch {
                        drawerState.close()
                    }
                },
            ) {
                //AndroidViewBinding(ContentMainBinding::inflate)
            }
        }
    }
}

@Composable
@OptIn(ExperimentalMaterial3Api::class)
fun TodoScaffold(
    drawerState: DrawerState,
    onDrawItemClicked: (String) -> Unit,
    content: @Composable () -> Unit
) {
    TodoTheme {
        ModalNavigationDrawer(
            drawerState = drawerState,
            drawerContent = {

            },
            content = content
        )
    }
}
