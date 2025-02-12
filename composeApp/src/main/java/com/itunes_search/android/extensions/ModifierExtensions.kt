package com.itunes_search.android.extensions

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Stable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.itunes_search.design.DesignTokens
import com.itunes_search.design.SizePreset

@Stable
fun Modifier.themePadding(
    start: SizePreset = SizePreset.Md,
    top: SizePreset = SizePreset.Md,
    end: SizePreset = SizePreset.Md,
    bottom: SizePreset = SizePreset.Md,
) = padding(
    start = DesignTokens.Spacing.h(start).dp,
    top = DesignTokens.Spacing.v(top).dp,
    end = DesignTokens.Spacing.h(end).dp,
    bottom = DesignTokens.Spacing.v(bottom).dp,
)

@Stable
fun Modifier.themePadding(
    horizontal: SizePreset = SizePreset.Md,
    vertical: SizePreset = SizePreset.Md,
) = padding(
    horizontal = DesignTokens.Spacing.h(horizontal).dp,
    vertical = DesignTokens.Spacing.v(vertical).dp,
)

@Stable
fun Modifier.themePadding(all: SizePreset = SizePreset.Md) =
    padding(
        horizontal = DesignTokens.Spacing.h(all).dp,
        vertical = DesignTokens.Spacing.v(all).dp,
    )

@Stable
fun Modifier.themePaddingTop(value: SizePreset = SizePreset.Md) =
    padding(
        top = DesignTokens.Spacing.v(value).dp,
    )

@Stable
fun Modifier.themePaddingBottom(value: SizePreset = SizePreset.Md) =
    padding(
        bottom = DesignTokens.Spacing.v(value).dp,
    )

@Stable
fun Modifier.themePaddingStart(value: SizePreset = SizePreset.Md) =
    padding(
        start = DesignTokens.Spacing.v(value).dp,
    )

@Stable
fun Modifier.themePaddingEnd(value: SizePreset = SizePreset.Md) =
    padding(
        end = DesignTokens.Spacing.v(value).dp,
    )

@Stable
fun Modifier.themePaddingH(value: SizePreset = SizePreset.Md) =
    padding(
        horizontal = DesignTokens.Spacing.h(value).dp,
    )

@Stable
fun Modifier.themePaddingV(value: SizePreset = SizePreset.Md) =
    padding(
        vertical = DesignTokens.Spacing.v(value).dp,
    )

@Stable
fun Modifier.themeSpacerH(sized: SizePreset = SizePreset.Md) =
    width(
        DesignTokens.Spacing.h(sized).dp,
    )

@Stable
fun Modifier.themeSpacerV(sized: SizePreset = SizePreset.Md) =
    height(
        DesignTokens.Spacing.v(sized).dp,
    )