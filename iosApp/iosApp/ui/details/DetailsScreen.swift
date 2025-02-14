//
//  DetailsScreen.swift
//  iosApp
//
//  Created by Donn Johnson Fabian on 2/13/25.
//  Copyright © 2025 orgName. All rights reserved.
//

import SwiftUI
import Factory
import shared

struct DetailsScreen: View {
  @StateObject private var themeManager = Container.shared.themeManager()
  
  let content: ContentModel?
  let onBack: () -> Void
  
  var body: some View {
    Scaffold(
      topBar:
        Button(action: onBack) {
          Image(systemName: "arrow.left")
            .foregroundColor(themeManager.theme.onBackgroundColor)
          padding()
        }
    ){ _ in
      if let content = content {
        DetailsView(
          themeManager: themeManager,
          content: content
        )
      } else {
        ContentNotFound(themeManager: themeManager)
      }
    }
  }
}

private struct DetailsView: View {
  @StateObject var themeManager: ThemeManager
  
  let content: ContentModel
  
  var body: some View {
    ScrollView {
      VStack {
        ContentImage(url: content.artworkUrl100)
          .frame(maxWidth: .infinity)
          .frame(height: DesignTokens.image.contentDetailsImageHeight)
        
        ArtistInfoView(
          themeManager: themeManager,
          name: content.artistName
        )
        
        HorizontalDivider()
        
        TrackInfoView(
          themeManager: themeManager,
          content: content
        )
        
        if let description = content.description_ {
          DescriptionView(
            themeManager: themeManager,
            about: description
          )
        }
      }
      .frame(
        maxWidth: .infinity,
        maxHeight: .infinity,
        alignment: .top
      )
    }
  }
}

struct ArtistInfoView: View {
  @StateObject var themeManager: ThemeManager
  let name: String
  
  var body: some View {
    Text(name)
      .styled(as: .title, sized: .md, color: themeManager.theme.onBackgroundColor)
  }
}

struct TrackInfoView: View {
  @StateObject var themeManager: ThemeManager
  let content: ContentModel
  
  var body: some View {
    VStack {
      if let collectionName = content.collectionName {
        ItemView(
          label: R.string.localizable.album(),
          value: {
            Text(collectionName)
              .styled(sized: .sm, color: themeManager.theme.onBackgroundColor)
          }
        )
      }
      
      if let trackName = content.trackName {
        ItemView(
          label: R.string.localizable.track(),
          value: {
            Text(trackName)
              .styled(sized: .sm, color: themeManager.theme.onBackgroundColor)
          }
        )
      }
      
      if let releaseDate = content.releaseDateDisplay {
        ItemView(
          label: R.string.localizable.release_date(),
          value: {
            Text(releaseDate)
              .styled(sized: .sm, color: themeManager.theme.onBackgroundColor)
          }
        )
      }
      
      ItemView(
        label: R.string.localizable.genre(),
        value: {
          GenreView(genre: content.primaryGenreName)
        }
      )
      
      if let trackTime = content.trackTime {
        ItemView(
          label: R.string.localizable.track_duration(),
          value: {
            Text(trackTime)
              .styled(sized: .sm, color: themeManager.theme.onBackgroundColor)
          }
        )
      }
      
      if let collectionPrice = content.collectionPrice {
        ItemView(
          label: R.string.localizable.price(),
          value: {
            PriceView(
              price: "\(collectionPrice)",
              currency: content.currency
            )
          }
        )
      }
      
    }
    .frame(maxWidth: .infinity)
  }
}

struct DescriptionView: View {
  @StateObject var themeManager: ThemeManager
  
  let about: String
  
  var body: some View {
    VStack {
      Text(R.string.localizable.about_the_artist())
        .styled(as: .title, sized: .sm, color: themeManager.theme.onBackgroundColor)
      
      Text(about)
        .styled(as: .title, sized: .sm, color: themeManager.theme.onBackgroundColor)
    }
    .frame(maxWidth: .infinity)
  }
}

struct ContentNotFound: View {
  @StateObject var themeManager: ThemeManager
  
  var body: some View {
    VStack {
      Text(R.string.localizable.content_not_found())
        .styled(as: .title, sized: .md, color: themeManager.theme.onBackgroundColor)
    }
    .frame(
      maxWidth: .infinity,
      maxHeight: .infinity,
      alignment: .center
    )
  }
}

#Preview {
  VStack {
    DetailsScreen(
      content: nil,
      onBack: {}
    )
    
    DetailsScreen(
      content: Faker.shared.content.build(),
      onBack: {}
    )
  }
}
