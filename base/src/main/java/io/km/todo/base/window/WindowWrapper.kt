package io.km.todo.base.window

import android.view.*
import android.view.accessibility.AccessibilityEvent

/**
 * default wrapper for window callback.
 * extend WindowWrapper and implement what you need
 *
 * @author pengfei.huang
 * create on 2022/6/27
 */
open class WindowWrapper(private val real: Window.Callback) : Window.Callback {

    override fun dispatchKeyEvent(event: KeyEvent?): Boolean {
        return real.dispatchKeyEvent(event)
    }

    override fun dispatchKeyShortcutEvent(event: KeyEvent?): Boolean {
        return real.dispatchKeyShortcutEvent(event)
    }

    override fun dispatchTouchEvent(event: MotionEvent?): Boolean {
        return real.dispatchTouchEvent(event)
    }

    override fun dispatchTrackballEvent(event: MotionEvent?): Boolean {
        return real.dispatchTrackballEvent(event)
    }

    override fun dispatchGenericMotionEvent(event: MotionEvent?): Boolean {
        return real.dispatchGenericMotionEvent(event)
    }

    override fun dispatchPopulateAccessibilityEvent(event: AccessibilityEvent?): Boolean {
        return real.dispatchPopulateAccessibilityEvent(event)
    }

    override fun onCreatePanelView(featureId: Int): View? {
        return real.onCreatePanelView(featureId)
    }

    override fun onCreatePanelMenu(featureId: Int, menu: Menu): Boolean {
        return real.onCreatePanelMenu(featureId, menu)
    }

    override fun onPreparePanel(featureId: Int, view: View?, menu: Menu): Boolean {
        return real.onPreparePanel(featureId, view, menu)
    }

    override fun onMenuOpened(featureId: Int, menu: Menu): Boolean {
        return real.onMenuOpened(featureId, menu)
    }

    override fun onMenuItemSelected(featureId: Int, item: MenuItem): Boolean {
        return real.onMenuItemSelected(featureId, item)
    }

    override fun onWindowAttributesChanged(attrs: WindowManager.LayoutParams?) {
        real.onWindowAttributesChanged(attrs)
    }

    override fun onContentChanged() {
        real.onContentChanged()
    }

    override fun onWindowFocusChanged(hasFocus: Boolean) {
        return real.onWindowFocusChanged(hasFocus)
    }

    override fun onAttachedToWindow() {
        real.onAttachedToWindow()
    }

    override fun onDetachedFromWindow() {
        real.onDetachedFromWindow()
    }

    override fun onPanelClosed(featureId: Int, menu: Menu) {
        return real.onPanelClosed(featureId, menu)
    }

    override fun onSearchRequested(): Boolean {
        return real.onSearchRequested()
    }

    override fun onSearchRequested(searchEvent: SearchEvent?): Boolean {
        return real.onSearchRequested()
    }

    override fun onWindowStartingActionMode(callback: ActionMode.Callback?): ActionMode? {
        return real.onWindowStartingActionMode(callback)
    }

    override fun onWindowStartingActionMode(callback: ActionMode.Callback?, type: Int): ActionMode? {
        return real.onWindowStartingActionMode(callback, type)
    }

    override fun onActionModeStarted(mode: ActionMode?) {
        real.onActionModeStarted(mode)
    }

    override fun onActionModeFinished(mode: ActionMode?) {
        real.onActionModeFinished(mode)
    }
}