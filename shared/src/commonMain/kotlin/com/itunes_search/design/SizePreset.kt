package com.itunes_search.design

sealed interface SizePreset {
    data object Xs : SizePreset

    data object Sm : SizePreset

    data object Md : SizePreset

    data object Lg : SizePreset

    data object Xl : SizePreset

    data object Xxl : SizePreset

    data class Custom(
        val value: Double,
    ) : SizePreset

    // Functions
    fun incBy(value: Int): SizePreset {
        var base = this
        repeat(value) { base = ++base }
        return base
    }

    fun decBy(value: Int): SizePreset {
        var base = this
        repeat(value) { base = --base }
        return base
    }

    fun adjustBy(value: Int): SizePreset =
        when {
            value < 0 -> decBy(-value)
            value > 0 -> incBy(value)
            else -> this
        }

    // Operators
    operator fun inc() =
        when (this) {
            Xs -> Sm
            Sm -> Md
            Md -> Lg
            Lg -> Xl
            Xl -> Xxl
            Xxl -> this
            is Custom -> Custom(this.value + 1)
        }

    operator fun dec() =
        when (this) {
            Xs -> this
            Sm -> Xs
            Md -> Sm
            Lg -> Md
            Xl -> Lg
            Xxl -> Xl
            is Custom -> Custom(this.value - 1)
        }
}
