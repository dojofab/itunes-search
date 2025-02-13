package com.itunes_search.data.network.api

import com.itunes_search.data.network.api.NetworkConfig.BASE_URL
import com.itunes_search.data.network.api.NetworkConfig.DEFAULT_LIMIT_VALUE
import com.itunes_search.data.network.api.NetworkConfig.DEFAULT_SEARCH_VALUE
import com.itunes_search.data.network.api.NetworkConfig.LIMIT_PARAMETER
import com.itunes_search.data.network.api.NetworkConfig.REQUEST_TIMEOUT
import com.itunes_search.data.network.api.NetworkConfig.SEARCH_END_POINT
import com.itunes_search.data.network.api.NetworkConfig.SOCKET_TIMEOUT
import com.itunes_search.data.network.api.NetworkConfig.TERM_PARAMETER
import com.itunes_search.domain.SearchResponse
import com.itunes_search.system.AppLogger
import io.ktor.client.HttpClient
import io.ktor.client.plugins.HttpTimeout
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.request.get
import io.ktor.client.statement.HttpResponse
import io.ktor.client.statement.bodyAsText
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

class ApiClient {
    private val httpClient = HttpClient {
        defaultRequest {
            url(BASE_URL)
        }

        install(HttpTimeout) {
            socketTimeoutMillis = SOCKET_TIMEOUT
            requestTimeoutMillis = REQUEST_TIMEOUT
        }

        install(ContentNegotiation) {
            json(
                json = Json {
                    ignoreUnknownKeys = true
                }
            )
        }

        install(Logging) {
            logger = object: Logger {
                override fun log(message: String) {
                    AppLogger.debug("Ktor HTTP Client: $message")
                }
            }
            level = LogLevel.ALL
        }
    }

    suspend fun search(
        term: String?,
        limit: Int?
    ): SearchResponse {
        val json = Json {
            ignoreUnknownKeys = true
        }

        val response: HttpResponse = httpClient.get(SEARCH_END_POINT) {
            url {
                parameters.append(TERM_PARAMETER, term ?: DEFAULT_SEARCH_VALUE)
                parameters.append(LIMIT_PARAMETER, limit?.toString() ?: DEFAULT_LIMIT_VALUE.toString())
            }
        }

        // Read response as text
        // Special case as the response content type is text/javascript
        val jsonString = response.bodyAsText()

        return json.decodeFromString<SearchResponse>(jsonString)
    }
}
