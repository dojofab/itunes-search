//
//  AppBackgroundGradient.swift
//  iosApp
//
//  Created by Donn Johnson Fabian on 2/13/25.
//  Copyright © 2025 orgName. All rights reserved.
//

import SwiftUI
import Factory

struct AppBackgroundGradient<ContentView: View>: View
where ContentView: View{
  @StateObject private var themeManager = Container.shared.themeManager()
  
  @ViewBuilder var content: ContentView
  
  init(
    @ViewBuilder content: () -> ContentView
  ) {
    self.content = content()
  }
  
  var body: some View {
    ZStack {
      LinearGradient(
        gradient: Gradient(
          colors: [
            themeManager.theme.backgroundColor,
            themeManager.theme.backgroundColor,
            themeManager.theme.onPrimaryColor
          ]
        ),
        startPoint: .top,
        endPoint: .bottom
      )
      
      content
    }
  }
}

#Preview {
  AppBackgroundGradient(
    content: {
      Text("test")
    }
  )
}
