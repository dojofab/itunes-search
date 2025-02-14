//
//  ContentImage.swift
//  iosApp
//
//  Created by Donn Johnson Fabian on 2/14/25.
//  Copyright © 2025 orgName. All rights reserved.
//

import SwiftUI
import NukeUI

struct ContentImage: View {
  let url: String
  
  var body: some View {
    LazyImage(url: url.toURL()) { state in
      if let image = state.image {
        image
          .resizable()
          .scaledToFill()
      }
    }
  }
}

#Preview {
  ContentImage(
    url: "https://cdn.britannica.com/79/232779-050-6B0411D7/German-Shepherd-dog-Alsatian.jpg"
  )
}
