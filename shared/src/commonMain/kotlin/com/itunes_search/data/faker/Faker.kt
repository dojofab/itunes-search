package com.itunes_search.data.faker

import kotlin.random.Random

object Faker {
    val content by lazy { ContentGenerator() }

    fun <T> randomOptional(
        probabilityOfNonNull: Double = 0.5,
        builder: () -> T
    ): T? {
        val probability = minOf(maxOf(0.0, probabilityOfNonNull), 1.0)
        val probabilityOfNull = 1.0 - probability
        val randomBound =
            if (probabilityOfNull == 0.0) {
                1
            } else {
                (1.0 / probabilityOfNull).toInt()
            }

        return if (Random.nextInt(randomBound) == randomBound - 1) {
            null
        } else {
            builder()
        }
    }
}