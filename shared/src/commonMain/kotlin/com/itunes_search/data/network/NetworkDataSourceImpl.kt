package com.itunes_search.data.network

import com.itunes_search.data.network.api.ApiClient
import com.itunes_search.domain.SearchResponse

class NetworkDataSourceImpl(
    private val apiClient: ApiClient
): NetworkDataSource {

    override suspend fun search(
        term: String?,
        limit: Int?
    ): Result<SearchResponse> =
        runCatching {
            return@runCatching apiClient.search(
                term = term,
                limit = limit
            )
        }
}