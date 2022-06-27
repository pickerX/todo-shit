package io.km.todo.base.provider

import android.annotation.SuppressLint
import android.app.Activity
import android.app.Application
import android.content.ContentProvider
import android.content.ContentValues
import android.database.Cursor
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.util.SparseArray
import androidx.core.util.forEach
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import io.km.todo.base.BuildConfig
import io.km.todo.base.ResReleaseCallback
import io.km.todo.base.SimpleCallback
import io.km.todo.base.window.WindowTouchProxy
import java.lang.ref.WeakReference

class AppLifecycleInitializer : ContentProvider() {

    override fun onCreate(): Boolean {
        AppLifecycleProvider.initLifecycleObserver(context!!.applicationContext as Application)
        return true
    }

    override fun query(
        uri: Uri,
        projection: Array<String>?,
        selection: String?,
        selectionArgs: Array<String>?,
        sortOrder: String?
    ): Cursor? = null

    override fun getType(uri: Uri): String? = null

    override fun insert(uri: Uri, values: ContentValues?): Uri? = null

    override fun delete(uri: Uri, selection: String?, selectionArgs: Array<String>?): Int = 0

    override fun update(
        uri: Uri,
        values: ContentValues?,
        selection: String?,
        selectionArgs: Array<String>?
    ): Int = 0
}

class OnUserInteractionResponse {
    // 需要监听的页面
    var pageObserver = mutableListOf<Class<*>>()

    var callback: SimpleCallback = null
}

object AppLifecycleProvider : ResReleaseCallback {

    private var mTopActivity: WeakReference<Activity>? = null
    private var mTopFragment: WeakReference<Fragment>? = null
    private var activityCount = 0
    private var fragmentCount = 0

    private val showLog = BuildConfig.DEBUG
    // private const val showLog = false

    // track fragment log or not: open when debug
    private val trackFragment = BuildConfig.DEBUG

    // limit the callbacks size
    val onPageCallbacks = SparseArray<() -> Unit>(3)

    fun getTopActivity(): Activity? = mTopActivity?.get()
    fun getTopFragment(): Fragment? = mTopFragment?.get()

    /**
     * 监听页面的用户操作响应
     */
    var userInteraction: OnUserInteractionResponse? = null

    fun initLifecycleObserver(application: Application) {
        application.registerActivityLifecycleCallbacks(object :
            Application.ActivityLifecycleCallbacks {

            @SuppressLint("ClickableViewAccessibility")
            override fun onActivityCreated(activity: Activity, savedInstanceState: Bundle?) {
                //handlerUserInput(activity)
                handleFragmentHandler(activity)
            }

            override fun onActivityStarted(activity: Activity) {
                activityCount++
                log("start activity:${activity.javaClass.simpleName}-${activityCount}")
            }

            override fun onActivityResumed(activity: Activity) {
                mTopActivity?.clear()
                mTopActivity = WeakReference(activity)

                onPageCallbacks.forEach { _, cb -> cb() }
            }

            override fun onActivityPaused(activity: Activity) {}

            override fun onActivityStopped(activity: Activity) {
                activityCount--
                log("stop activity:${activity.javaClass.simpleName}-${activityCount}")
            }

            override fun onActivityDestroyed(activity: Activity) {
                log("destroy activity:${activity.javaClass.simpleName}-${activityCount}")
            }

            override fun onActivitySaveInstanceState(activity: Activity, outState: Bundle) {}
        })
    }

    private fun handleFragmentHandler(activity: Activity) {
        if (activity !is FragmentActivity) return
        activity.supportFragmentManager.registerFragmentLifecycleCallbacks(
            object : FragmentManager.FragmentLifecycleCallbacks() {

                override fun onFragmentResumed(fm: FragmentManager, f: Fragment) {
                    super.onFragmentResumed(fm, f)
                    mTopFragment?.clear()
                    mTopFragment = WeakReference(f)
                    fragmentCount++
                    handlerUserInteractionInFragment(activity, f)
                    if (trackFragment) log("resume fragment:${f.javaClass.canonicalName}-${fragmentCount}")
                }

                override fun onFragmentDestroyed(fm: FragmentManager, f: Fragment) {
                    super.onFragmentDestroyed(fm, f)
                    mTopFragment?.clear()
                    fragmentCount--
                    if (trackFragment) log("destroy fragment:${f.javaClass.simpleName}-${fragmentCount}")
                }
            }, true
        )
    }

    private fun log(message: String) {
        if (showLog) Log.i("AppLifecycle", ">> $message")
    }

    override fun release() {
        onPageCallbacks.clear()
    }

    /**
     * observer user interaction
     */
    @SuppressLint("ClickableViewAccessibility")
    private fun handlerUserInteractionInFragment(activity: FragmentActivity, f: Fragment) {
        userInteraction?.let {
            if (!it.pageObserver.contains(f.javaClass)) {
                return@let
            }
            activity.window.callback = WindowTouchProxy(activity.window.callback).apply {
                actionDown = { it.callback?.invoke() }
            }
        }
    }
}