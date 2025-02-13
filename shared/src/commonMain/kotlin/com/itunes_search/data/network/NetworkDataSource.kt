package com.itunes_search.data.network

import com.itunes_search.domain.SearchResponse

interface NetworkDataSource {

    suspend fun search(
        term: String?,
        limit: Int?
    ): Result<SearchResponse>
}