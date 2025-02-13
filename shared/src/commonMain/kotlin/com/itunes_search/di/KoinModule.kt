package com.itunes_search.di

import org.koin.core.context.startKoin

fun initKoin() =
    startKoin {
        modules(appModule())
    }
