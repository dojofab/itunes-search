package com.itunes_search.utils

import io.ktor.util.network.UnresolvedAddressException
import kotlinx.serialization.SerializationException

object AsyncError {
    fun getRepositoryError(error: Throwable): RepositoryError =
        when (error) {
            is UnresolvedAddressException -> {
                RepositoryError(
                    errorCode = RepositoryErrorCode.NetworkError,
                    errorMessage = Message.NETWORK_ERROR
                )
            }
            is SerializationException -> {
                RepositoryError(
                    errorCode = RepositoryErrorCode.SerializationError,
                    errorMessage = Message.SOMETHING_WENT_WRONG
                )
            }
            else -> {
                RepositoryError(
                    errorCode = RepositoryErrorCode.HttpError,
                    errorMessage = error.message ?: Message.SERVER_ERROR
                )
            }
        }
}