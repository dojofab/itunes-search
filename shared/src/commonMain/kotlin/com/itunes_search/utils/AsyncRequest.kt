package com.itunes_search.utils

import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.onStart

abstract class AsyncRequest {
    suspend fun <T> apiCall(call: suspend () -> Result<T>) =
        flow {
            call
                .invoke()
                .onSuccess {
                    emit(AsyncOperation.Loaded(it))
                }.onFailure {
                    emit(AsyncOperation.Failed(it))
                }
        }.onStart {
            emit(AsyncOperation.Loading)
        }
}