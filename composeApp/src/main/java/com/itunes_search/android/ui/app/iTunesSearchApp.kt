package com.itunes_search.android.ui.app

import android.app.Application
import com.itunes_search.di.initKoin
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class iTunesSearchApp: Application() {
    override fun onCreate() {
        super.onCreate()
        initKoin()
    }
}