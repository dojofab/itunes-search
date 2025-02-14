//
//  MainScreen.swift
//  iosApp
//
//  Created by Donn Johnson Fabian on 2/13/25.
//  Copyright © 2025 orgName. All rights reserved.
//

import SwiftUI
import Factory
import shared

struct MainScreen: View {
  @StateObject private var themeManager = Container.shared.themeManager()
  
  private let viewModel = Container.shared.mainScreenViewModel()
  
  let onContentClick: (ContentModel) -> Void
  
  var body: some View {
    MainView(
      themeManager: themeManager,
      uiState: viewModel.uiState,
      onContentClick: onContentClick
    )
  }
}

private struct MainView: View {
  let themeManager: ThemeManager
  let uiState: ContentUiState
  let onContentClick: (ContentModel) -> Void
  
  private var columns: [GridItem] {
    Array(
      repeating: .init(.flexible(), spacing: 0, alignment: .center),
      count: 2
    )
  }

  var body: some View {
    Scaffold(
      topBar: TopBar()
    ){ _ in
      AppBackgroundGradient {
        VStack {
          SearchBar(searchValue: .constant(""))
            .frame(maxWidth: .infinity)
          
          if let error = uiState.error {
            ErrorView(
              themeManager: themeManager,
              error: error,
              onRetry: {}
            )
          }
          
          if let contents = uiState.contents {
            if contents.isEmpty {
              NoContentsAvailable(
                themeManager: themeManager
              )
            }
            
            ScrollView {
              LazyVGrid(columns: columns, spacing: 10) {
                ForEach(contents, id: \.self) { content in
                  ContentItem(
                    content: content,
                    onContentClick: {
                      onContentClick(content)
                    }
                  )
                  .padding(5)
                  .frame(minHeight: CGFloat(DesignTokens.content.ContentHeight))
                }
              }
              .frame(maxWidth: .infinity)
            }
          }
        }
        .frame(
          maxWidth: .infinity,
          maxHeight: .infinity,
          alignment: .top
        )
      }
    }
    .ignoresSafeArea(.container, edges: .bottom)
  }
}

private struct ErrorView: View {
  @StateObject var themeManager: ThemeManager
  
  let error: RepositoryError
  let onRetry: () -> Void
  
  var body: some View {
    VStack {
      Text(error.errorMessage)
        .styled(
          as: .title, sized: .md, color: themeManager.theme.onBackgroundColor
        )
      
      Button(action: onRetry) {
        Text(R.string.localizable.retry())
          .styled(
            as: .label, sized: .lg, color: themeManager.theme.onBackgroundColor
          )
      }
    }
    .frame(
      maxWidth: .infinity,
      maxHeight: .infinity,
      alignment: .center
    )
  }
}

private struct NoContentsAvailable: View {
  @StateObject var themeManager: ThemeManager
  
  var body: some View {
    VStack {
      Text(R.string.localizable.no_available_contents())
        .styled(
          as: .title, sized: .sm, color: themeManager.theme.onBackgroundColor
        )
    }
    .frame(
      maxWidth: .infinity,
      maxHeight: .infinity,
      alignment: .center
    )
  }
}

#Preview {
  MainScreen(
    onContentClick: { _ in }
  )
}
