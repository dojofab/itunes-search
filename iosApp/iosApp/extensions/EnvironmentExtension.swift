//
//  EnvironmentExtension.swift
//  iosApp
//
//  Created by Donn Johnson Fabian on 2/14/25.
//  Copyright © 2025 orgName. All rights reserved.
//

import SwiftUI

private struct ContentColorKey: EnvironmentKey {
  static let defaultValue: Color? = nil
}

extension EnvironmentValues {
  var contentColor: Color? {
    get {
      self[ContentColorKey.self]
    }
    set {
      self[ContentColorKey.self] = newValue
    }
  }
}

extension View {
  func contentColor(_ color: Color) -> some View {
    environment(\.contentColor, color)
  }
}
