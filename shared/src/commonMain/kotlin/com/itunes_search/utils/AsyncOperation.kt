package com.itunes_search.utils

sealed class AsyncOperation<out T> {
    data object Loading : AsyncOperation<Nothing>()

    data class Failed(
        val error: Throwable
    ) : AsyncOperation<Nothing>()

    data class Loaded<out Value>(
        val value: Value
    ) : AsyncOperation<Value>()
}
