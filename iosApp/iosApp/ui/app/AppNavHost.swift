//
//  AppNavHost.swift
//  iosApp
//
//  Created by Donn Johnson Fabian on 2/13/25.
//  Copyright © 2025 orgName. All rights reserved.
//

import SwiftUI
import Factory

struct AppNavHost: View {
  @StateObject private var viewModel = Container.shared.appNavHostViewModel()

  var body: some View {
    // Simple navigaition
    // Ideal to implement route
    NavigationStack {
      MainScreen(
        onContentClick: { content in
          viewModel.setContent(content)
        }
      )
      .navigationDestination(item: $viewModel.selectedContent) { content in
        DetailsScreen(
          content: content,
          onBack: {
          
          }
        )
      }
    }
  }
}

