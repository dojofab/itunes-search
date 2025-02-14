//
//  AppNavHostViewModel.swift
//  iosApp
//
//  Created by Donn Johnson Fabian on 2/14/25.
//  Copyright © 2025 orgName. All rights reserved.
//

import SwiftUI
import shared

class AppNavHostViewModel: ObservableObject {
  @Published var selectedContent: ContentModel? = nil

  func setContent(_ content: ContentModel) {
    selectedContent = content
  }
}

