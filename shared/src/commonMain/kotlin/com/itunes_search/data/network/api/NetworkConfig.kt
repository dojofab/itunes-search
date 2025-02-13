package com.itunes_search.data.network.api

object NetworkConfig {
    const val BASE_URL = "https://itunes.apple.com"
    const val SEARCH_END_POINT = "search?"
    const val TERM_PARAMETER = "term"
    const val DEFAULT_SEARCH_VALUE = "all"
    const val LIMIT_PARAMETER = "limit"
    const val DEFAULT_LIMIT_VALUE = 50

    const val SOCKET_TIMEOUT: Long = 60_000
    const val REQUEST_TIMEOUT: Long = 60_000
}