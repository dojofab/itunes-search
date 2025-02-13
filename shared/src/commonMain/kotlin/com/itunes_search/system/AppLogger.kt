package com.itunes_search.system

import io.github.aakira.napier.DebugAntilog
import io.github.aakira.napier.Napier

object AppLogger {
    private const val TAG = "ITunesSearch"

    init {
        Napier.base(DebugAntilog())
    }

    fun verbose(
        message: String,
        throwable: Throwable? = null,
        tag: String? = null
    ) {
        Napier.v(message = message, throwable = throwable, tag = tag ?: TAG)
    }

    fun debug(
        message: String,
        throwable: Throwable? = null,
        tag: String? = null
    ) {
        Napier.d(message = message, throwable = throwable, tag = tag ?: TAG)
    }

    fun info(
        message: String,
        throwable: Throwable? = null,
        tag: String? = null
    ) {
        Napier.i(message = message, throwable = throwable, tag = tag ?: TAG)
    }

    fun warning(
        message: String,
        throwable: Throwable? = null,
        tag: String? = null
    ) {
        Napier.w(message = message, throwable = throwable, tag = tag ?: TAG)
    }

    fun error(
        message: String,
        throwable: Throwable? = null,
        tag: String? = null
    ) {
        Napier.e(message = message, throwable = throwable, tag = tag ?: TAG)
    }

    fun wtf(
        message: String,
        throwable: Throwable? = null,
        tag: String? = null
    ) {
        Napier.wtf(message = message, throwable = throwable, tag = tag ?: TAG)
    }
}