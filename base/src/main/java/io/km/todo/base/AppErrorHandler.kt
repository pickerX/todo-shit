package io.km.todo.base

import android.content.Context
import android.util.Log
import android.widget.Toast

class AppErrorHandler(private val context: Context) : ErrorHandler {

    override fun handleError(error: Throwable) {
        val message = "error: ${error.message}"
        Log.d(TAG, message)
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }

    companion object {

        private const val TAG = "AppErrorHandler"
    }
}
