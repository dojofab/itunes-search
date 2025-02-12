package com.itunes_search

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform