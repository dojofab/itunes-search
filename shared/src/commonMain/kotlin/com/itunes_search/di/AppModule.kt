package com.itunes_search.di

import com.itunes_search.data.local.LocalDataSource
import com.itunes_search.data.local.LocalDataSourceImpl
import com.itunes_search.data.network.NetworkDataSource
import com.itunes_search.data.network.NetworkDataSourceImpl
import com.itunes_search.data.network.api.ApiClient
import com.itunes_search.data.repository.ContentRepository
import com.itunes_search.data.repository.ContentRepositoryImpl
import org.koin.dsl.module

fun appModule() =
    module {
        single { ApiClient() }
        single<LocalDataSource> { LocalDataSourceImpl() }
        single<NetworkDataSource> { NetworkDataSourceImpl(get()) }
        single<ContentRepository> { ContentRepositoryImpl(get(), get()) }
    }