package com.itunes_search.android.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.itunes_search.android.extensions.onBackgroundMutedColor
import com.itunes_search.android.extensions.themePaddingV
import com.itunes_search.android.ui.theme.AppTheme
import com.itunes_search.android.ui.theme.ThemeManager
import com.itunes_search.data.faker.Faker
import com.itunes_search.design.DesignTokens
import com.itunes_search.design.SizePreset
import com.itunes_search.domain.ContentModel

@Composable
fun ContentItem(
    content: ContentModel,
    onContentClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Surface(
        modifier = modifier
            .clickable {
                onContentClick()
            },
        color = Color.Transparent
    ) {
        Column(
            modifier = Modifier
        ) {
            ContentImage(
                url = content.artworkUrl100,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(DesignTokens.Image.contentImageHeight.dp)
            )

            Text(
                content.artistName,
                modifier = Modifier.themePaddingV(SizePreset.Sm),
                style = MaterialTheme.typography.titleSmall,
                color = MaterialTheme.colorScheme.onBackground,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis,
            )

            Text(
                content.country,
                style = MaterialTheme.typography.labelSmall,
                color = MaterialTheme.colorScheme.onBackground,
            )

            Text(
                content.primaryGenreName,
                style = MaterialTheme.typography.labelSmall,
                color = ThemeManager.theme.onBackgroundMutedColor
            )
        }
    }
}

@Preview
@Composable
private fun ContentItemPreview() {
    AppTheme {
        ContentItem(
            content = Faker.content.build(),
            onContentClick = {}
        )
    }
}