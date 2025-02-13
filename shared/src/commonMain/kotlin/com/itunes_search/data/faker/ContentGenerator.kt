package com.itunes_search.data.faker

import com.itunes_search.domain.Content

class ContentGenerator internal constructor() : Generator<Content>  {

    override fun build(overrides: Map<String, Any>): Content {
        return Content(
            wrapperType = "audiobook",
            artistId = 1211547575,
            collectionId = 1493350436,
            artistName = "Boken The Dog",
            collectionName = "Boken The Dog - It´s All About Me!",
            collectionCensoredName = "Boken The Dog - It´s All About Me!",
            collectionViewUrl = "https://books.apple.com/us/audiobook/boken-the-dog-it-s-all-about-me/id1493350436?uo=4",
            artworkUrl60 = "https://is1-ssl.mzstatic.com/image/thumb/Music123/v4/e0/41/3e/e0413eb2-b00a-538b-a2f0-2ddd2c1b855d/9781916318120_cover.jpg/60x60bb.jpg",
            artworkUrl100 = "https://is1-ssl.mzstatic.com/image/thumb/Music123/v4/e0/41/3e/e0413eb2-b00a-538b-a2f0-2ddd2c1b855d/9781916318120_cover.jpg/100x100bb.jpg",
            collectionPrice = 0.00,
            collectionExplicitness = "cleaned",
            trackCount = 1,
            country = "USA",
            currency = "USD",
            releaseDate = "2020-01-31T08:00:00Z",
            primaryGenreName = "Kids & Young Adults",
            previewUrl = "https://audio-ssl.itunes.apple.com/itunes-assets/AudioPreview113/v4/41/d1/cb/41d1cb96-86d0-3b68-c156-136c6336d385/mzaf_11888134214380219820.std.aac.p.m4a",
            description = "Boken the dog - It´s all about me! It is what it says on the tin - an introduction to the adventures of Boken the Miniature Schnauzer. Before you can delve into his fun and fabulous adventures, you need to get to grips with who he is, where he lives, what he likes to do, who his amigos are and most importantly, what food he likes. Boken is a fun loving, very cheeky little chap who likes nothing more than having fun, exploring the world and loving those who love him back. Welcome to his introduction to himself and further books in his series where his adventures are fun, exciting, educational and, at times, a little bit crazy!"
        )
    }
}