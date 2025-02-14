//
//  ContentItem.swift
//  iosApp
//
//  Created by Donn Johnson Fabian on 2/14/25.
//  Copyright © 2025 orgName. All rights reserved.
//

import SwiftUI
import Factory
import shared

struct ContentItem: View {
  @StateObject private var themeManager = Container.shared.themeManager()
  
  let content: ContentModel
  let onContentClick: () -> Void
  
  var body: some View {
    Surface(
      color: .clear,
      shape: roundedContainerShape
    ) {
      VStack(alignment: .leading){
        ContentImage(
          url: content.artworkUrl100
        )
        .frame(maxWidth: .infinity)
        .frame(height: DesignTokens.image.contentImageHeight)
        
        Text(content.artistName)
          .styled(
            as: .title, sized: .sm, color: themeManager.theme.onBackgroundColor
          )
        
        Text(content.country)
          .styled(
            as: .label, sized: .sm, color: themeManager.theme.onBackgroundColor
          )
        
        Text(content.primaryGenreName)
          .styled(
            as: .title, sized: .sm, color: themeManager.theme.onBackgroundMutedColor
          )
      }
    }
    .onTapGesture {
      onContentClick()
    }
    .background(.yellow)
  }
}

#Preview {
  ContentItem(
    content: Faker.shared.content.build(),
    onContentClick: {}
  )
}
