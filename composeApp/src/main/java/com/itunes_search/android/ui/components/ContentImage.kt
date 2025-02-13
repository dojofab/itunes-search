package com.itunes_search.android.ui.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import coil.compose.AsyncImage

@Composable
fun ContentImage(
    url: String,
    modifier: Modifier = Modifier
) {
    AsyncImage(
        model = url,
        modifier = modifier,
        contentScale = ContentScale.Crop,
        contentDescription = null
    )
}