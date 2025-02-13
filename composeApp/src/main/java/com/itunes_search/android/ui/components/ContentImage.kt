package com.itunes_search.android.ui.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import coil.compose.AsyncImage
import com.itunes_search.android.ui.theme.AppTheme
import com.itunes_search.data.faker.Faker

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

@Preview
@Composable
private fun ContentImagePreview() {
    AppTheme {
        ContentImage(url = Faker.content.build().artworkUrl100)
    }
}