//
//  ThemeManager.swift
//  iosApp
//
//  Created by Donn Johnson Fabian on 2/14/25.
//  Copyright © 2025 orgName. All rights reserved.
//

import shared

class ThemeManager: ObservableObject {
  @Published var theme = ThemeProvider.shared.get(preset: .default_, isDarkScheme: true)
}
