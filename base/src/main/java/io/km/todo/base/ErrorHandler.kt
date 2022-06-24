package io.km.todo.base

import android.util.Log

/**
 *
 * @author pengfei.huang
 * create on 2022/6/24
 */
interface ErrorHandler {
    fun handleError(error: Throwable)

    companion object {

        private const val TAG = "ErrorHandler"

        val DEFAULT = object : ErrorHandler {

            override fun handleError(error: Throwable) {
                Log.e(TAG, "[${error.message}]")
            }
        }
    }
}