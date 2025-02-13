package com.itunes_search.data.faker

import kotlin.random.Random

interface Generator<T> {
    fun build(overrides: Map<String, Any> = emptyMap()): T

    fun buildMany(
        count: Int = Random.nextInt() + 1,
        overrides: Map<String, Any> = emptyMap()
    ): List<T> =
        (1..count).map {
            build(overrides)
        }

    fun <T> getOverrideOr(
        overrides: Map<String, Any>,
        key: String,
        or: T
    ): T {
        @Suppress("UNCHECKED_CAST")
        return (overrides[key] as? T) ?: or
    }
}
