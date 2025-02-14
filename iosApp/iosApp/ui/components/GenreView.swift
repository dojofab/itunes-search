//
//  GenreView.swift
//  iosApp
//
//  Created by Donn Johnson Fabian on 2/14/25.
//  Copyright © 2025 orgName. All rights reserved.
//

import SwiftUI
import Factory

struct GenreView: View {
  @StateObject private var themeManager = Container.shared.themeManager()
  
  let genre: String
  
  var body: some View {
    Surface(
      color: Color.green,
      shape: roundedContainerShape
    ){
      Text(genre)
        .styled(sized: .sm, color: themeManager.theme.backgroundColor)
    }
  }
}

#Preview {
  GenreView(
    genre: "Comedy"
  )
}
