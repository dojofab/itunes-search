package com.itunes_search.domain

import kotlinx.datetime.Instant
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime
import kotlinx.serialization.Serializable

@Serializable
data class SearchResponse(
    val resultCount: Int,
    val results: List<ContentModel>
)

@Serializable
data class ContentModel(
    val wrapperType: String,
    val kind: String? = null,
    val collectionId: Long? = null,
    val trackId: Long? = null,
    val artistId: Int? = null,
    val artistName: String,
    val collectionName: String? = null,
    val trackName: String? = null,
    val collectionCensoredName: String? = null,
    val trackCensoredName: String? = null,
    val collectionArtistId: Long? = null,
    val collectionArtistViewUrl: String? = null,
    val collectionViewUrl: String? = null,
    val trackViewUrl: String? = null,
    val previewUrl: String? = null,
    val artworkUrl30: String? = null,
    val artworkUrl60: String,
    val artworkUrl100: String,
    val collectionPrice: Double? = null,
    val trackPrice: Double? = null,
    val trackRentalPrice: Double? = null,
    val collectionHdPrice: Double? = null,
    val trackHdPrice: Double? = null,
    val trackHdRentalPrice: Double? = null,
    val releaseDate: String,
    val collectionExplicitness: String,
    val trackExplicitness: String? = null,
    val discCount: Int? = null,
    val discNumber: Int? = null,
    val trackCount: Int? = null,
    val trackNumber: Int? = null,
    val trackTimeMillis: Long? = null,
    val country: String,
    val currency: String,
    val primaryGenreName: String,
    val contentAdvisoryRating: String? = null,
    val shortDescription: String? = null,
    val longDescription: String? = null,
    val description: String? = null,
    val hasITunesExtras: Boolean? = null,
) {
    val trackTime: String?
        get() {
            if (trackTimeMillis == null) return null

            val totalSeconds = trackTimeMillis / 1000
            val hours = totalSeconds / 3600
            val minutes = (totalSeconds % 3600) / 60
            val seconds = totalSeconds % 60

            return if (hours > 0) {
                "${hours.toString().padStart(2, '0')}h:${minutes.toString().padStart(2, '0')}m:${seconds.toString().padStart(2, '0')}s"
            } else {
                "${minutes.toString().padStart(2, '0')}m:${seconds.toString().padStart(2, '0')}s"
            }
        }

    val releaseDateDisplay: String?
        get() {
            try {
                val instant = Instant.parse(releaseDate)
                val localDateTime = instant.toLocalDateTime(TimeZone.currentSystemDefault())

                val month = localDateTime.month.name.lowercase().replaceFirstChar { it.uppercase() }
                val day = localDateTime.dayOfMonth
                val year = localDateTime.year

                return "$month $day, $year"
            } catch(e: Exception) {
                return null
            }
        }
}