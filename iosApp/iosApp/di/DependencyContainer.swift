//
//  DependencyContainer.swift
//  iosApp
//
//  Created by Donn Johnson Fabian on 2/14/25.
//  Copyright © 2025 orgName. All rights reserved.
//

import Foundation
import Factory

extension SharedContainer {
  var themeManager: Factory<ThemeManager> {
    self { ThemeManager() }.singleton
  }
  
  var appNavHostViewModel: Factory<AppNavHostViewModel> {
    self { AppNavHostViewModel() }.singleton
  }
  
  var mainScreenViewModel: Factory<MainScreenViewModel> {
    self { MainScreenViewModel() }.singleton
  }
}
