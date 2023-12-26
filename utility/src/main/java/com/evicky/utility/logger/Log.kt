package com.evicky.utility.logger

import android.util.Log

object Log {

    fun v(tag: String, msg: String?, throwable: Throwable? = null) =
        msg?.run {
            Log.v(tag, this, throwable)
        }

    fun d(tag: String, msg: String?, throwable: Throwable? = null) =
        msg?.run {
            Log.d(tag, this, throwable)
        }

    fun i(tag: String, msg: String?, throwable: Throwable? = null) =
        msg?.run {
            Log.i(tag, this, throwable)
        }

    fun w(tag: String, msg: String?, throwable: Throwable? = null) =
        msg?.run {
            Log.w(tag, this, throwable)
        }

    fun e(tag: String, msg: String?, throwable: Throwable? = null) =
        msg?.run {
            Log.e(tag, this, throwable)
        }

}