package com.itunes_search.utils

sealed class RepositoryErrorCode {
    object NetworkError : RepositoryErrorCode()

    object HttpError : RepositoryErrorCode()

    object SerializationError : RepositoryErrorCode()

    object UnknownError : RepositoryErrorCode()
}

data class RepositoryError(
    val errorCode: RepositoryErrorCode,
    val errorMessage: String
)
