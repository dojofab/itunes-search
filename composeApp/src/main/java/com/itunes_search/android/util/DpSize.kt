package com.itunes_search.android.util

import androidx.compose.ui.unit.DpSize
import com.itunes_search.utils.LayoutAxis

val DpSize.layoutAxis: LayoutAxis
    get() = if (height < width) LayoutAxis.Horizontal else LayoutAxis.Vertical
