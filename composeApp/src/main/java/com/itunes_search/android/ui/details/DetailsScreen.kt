package com.itunes_search.android.ui.details

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.itunes_search.android.R
import com.itunes_search.android.annotations.DevicePreviews
import com.itunes_search.android.extensions.themePadding
import com.itunes_search.android.extensions.themePaddingH
import com.itunes_search.android.extensions.themePaddingV
import com.itunes_search.android.extensions.themeSpacerV
import com.itunes_search.android.extensions.toColor
import com.itunes_search.android.ui.components.AppGradientBackground
import com.itunes_search.android.ui.components.ContentImage
import com.itunes_search.android.ui.components.GenreView
import com.itunes_search.android.ui.components.ItemView
import com.itunes_search.android.ui.components.PriceView
import com.itunes_search.android.ui.theme.AppTheme
import com.itunes_search.design.ColorTokens
import com.itunes_search.design.DesignTokens
import com.itunes_search.design.SizePreset
import com.itunes_search.domain.Content

@Composable
fun DetailsScreen(
    content: Content?,
    modifier: Modifier = Modifier
) {
    if (content == null) {
        ContentNotFoundView(modifier = modifier)
    } else {
        DetailsView(
            content = content,
            modifier = modifier
        )
    }
}

@Composable
private fun DetailsView(
    content: Content,
    modifier: Modifier = Modifier
) {
    Scaffold(
        modifier = modifier,
        containerColor = Color.Black
    ) { padding ->
        AppGradientBackground {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(1.0f)
                    .padding(padding)
                    .verticalScroll(rememberScrollState()),
                verticalArrangement = Arrangement.Top,
            ) {
                ContentImage(
                    url = content.artworkUrl100,
                    modifier = Modifier
                        .fillMaxWidth()
                        .size(DesignTokens.Image.contentDetailsImageHeight.dp),
                )

                ArtistInfoView(
                    content = content
                )

                Divider()

                TrackInfoView(
                    content = content
                )

                content.description?.let {
                    DescriptionView(it)
                }
            }
        }
    }
}

@Composable
private fun ArtistInfoView(
    content: Content,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .themePadding()
    ) {
        Text(
            text = content.artistName,
            color = ColorTokens.onBackground.toColor(),
            style = MaterialTheme.typography.titleLarge
        )
    }
}

@Composable
private fun TrackInfoView(
    content: Content,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .themePaddingH()
    ) {
        Column(
            modifier = Modifier
                .themePaddingV(SizePreset.Xs),
            verticalArrangement = Arrangement.Top
        ) {
            content.collectionName?.let {
                ItemView(
                    modifier = Modifier.themePaddingV(SizePreset.Sm),
                    label = R.string.album,
                    value = {
                        Text(
                            text = it,
                            color = ColorTokens.onBackground.toColor(),
                            style = MaterialTheme.typography.bodySmall
                        )
                    }
                )
            }

            content.trackName?.let {
                ItemView(
                    modifier = Modifier.themePaddingV(SizePreset.Sm),
                    label = R.string.track,
                    value = {
                        Text(
                            text = it,
                            color = ColorTokens.onBackground.toColor(),
                            style = MaterialTheme.typography.bodySmall
                        )
                    }
                )
            }

            content.releaseDateDisplay?.let {
                ItemView(
                    modifier = Modifier.themePaddingV(SizePreset.Sm),
                    label = R.string.release_date,
                    value = {
                        Text(
                            text = it,
                            color = ColorTokens.onBackground.toColor(),
                            style = MaterialTheme.typography.bodySmall
                        )
                    }
                )
            }

            ItemView(
                modifier = Modifier.themePaddingV(SizePreset.Sm),
                label = R.string.genre,
                value = {
                    GenreView(content.primaryGenreName)
                }
            )

            content.trackTime?.let {
                ItemView(
                    modifier = Modifier.themePaddingV(SizePreset.Sm),
                    label = R.string.track_duration,
                    value = {
                        Text(
                            text = it,
                            color = ColorTokens.onBackground.toColor(),
                            style = MaterialTheme.typography.bodySmall
                        )
                    }
                )
            }

            content.collectionPrice?.let {
                ItemView(
                    modifier = Modifier.themePaddingV(SizePreset.Sm),
                    label = R.string.price,
                    value = {
                        PriceView(
                            price = it.toString(),
                            currency = content.currency
                        )
                    }
                )
            }
        }
    }
}

@Composable
private fun DescriptionView(
    about: String,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .themePadding()
    ) {
        Text(
            text = stringResource(R.string.about_the_artist),
            color = ColorTokens.onBackground.toColor(),
            style = MaterialTheme.typography.titleLarge
        )

        Spacer(modifier = Modifier.themeSpacerV(SizePreset.Sm))

        Text(
            text = about,
            color = ColorTokens.onBackground.toColor(),
            style = MaterialTheme.typography.bodySmall
        )
    }
}

@Composable
private fun Divider(
    modifier: Modifier = Modifier
) {
    HorizontalDivider(
        modifier = modifier
            .themePaddingH(),
        color = ColorTokens.onBackgroundMuted.toColor()
    )
}

@Composable
private fun ContentNotFoundView(
    modifier: Modifier = Modifier
) {
    AppGradientBackground {
        Column(
            modifier = modifier
                .fillMaxWidth()
                .background(
                    color = Color.Black
                ),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = stringResource(R.string.content_not_found),
                color = ColorTokens.background.toColor(),
                style = MaterialTheme.typography.titleLarge
            )
        }
    }
}

@DevicePreviews
@Composable
private fun DetailsViewPreview() {
    AppTheme {
        /*DetailsScreen(
            adaptiveInfo = currentWindowAdaptiveInfo(),
            content = null
        )*/
    }
}
