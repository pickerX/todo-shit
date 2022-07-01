package io.km.todo.shit.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import io.km.todo.base.theme.DarkThemeColors
import io.km.todo.base.theme.LightThemeColors
import io.km.todo.base.theme.ThemeTypography

@Composable
fun TodoTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colors = if (darkTheme) DarkThemeColors else LightThemeColors,
        typography = ThemeTypography,
        content = content
    )
}
