package io.km.todo.base.window

import android.view.MotionEvent
import android.view.Window
import io.km.todo.base.SimpleCallback

/**
 * window touch proxy
 *
 * @author pengfei.huang
 * create on 2022/6/27
 */
class WindowTouchProxy(real: Window.Callback) : WindowWrapper(real) {

    var actionDown: SimpleCallback = null
    var actionUp: SimpleCallback = null
    var actionMove: SimpleCallback = null

    override fun dispatchTouchEvent(event: MotionEvent?): Boolean {
        when (event?.action) {
            MotionEvent.ACTION_DOWN -> actionDown?.invoke()
            MotionEvent.ACTION_UP -> actionUp?.invoke()
            MotionEvent.ACTION_MOVE -> actionMove?.invoke()
        }
        return super.dispatchTouchEvent(event)
    }
}