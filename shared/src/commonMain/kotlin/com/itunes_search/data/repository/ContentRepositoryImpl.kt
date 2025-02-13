package com.itunes_search.data.repository

import com.itunes_search.data.local.LocalDataSource
import com.itunes_search.data.network.NetworkDataSource
import com.itunes_search.domain.SearchResponse
import com.itunes_search.utils.AsyncOperation
import com.itunes_search.utils.AsyncRequest
import kotlinx.coroutines.flow.Flow

class ContentRepositoryImpl(
    private val localDataSource: LocalDataSource,
    private val networkDataSource: NetworkDataSource
): AsyncRequest(), ContentRepository {

    override suspend fun search(
        term: String?,
        limit: Int?
    ): Flow<AsyncOperation<SearchResponse>> {
        return apiCall {
            networkDataSource.search(
                term = term,
                limit = limit
            )
        }
    }
}