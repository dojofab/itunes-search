package com.itunes_search.data.repository

import com.itunes_search.domain.SearchResponse
import com.itunes_search.utils.AsyncOperation
import kotlinx.coroutines.flow.Flow

interface ContentRepository {
    suspend fun search(
        term: String?,
        limit: Int?
    ): Flow<AsyncOperation<SearchResponse>>
}