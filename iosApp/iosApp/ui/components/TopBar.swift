//
//  TopBar.swift
//  iosApp
//
//  Created by Donn Johnson Fabian on 2/13/25.
//  Copyright © 2025 orgName. All rights reserved.
//

import SwiftUI
import Factory

struct TopBar: View {
  @StateObject private var themeManager = Container.shared.themeManager()
  
  var body: some View {
    HStack {
      Text(R.string.localizable.app_name())
        .styled(as: .title, sized: .md, color: themeManager.theme.onBackgroundColor)
    }
    .frame(
      maxWidth: .infinity,
      alignment: .center
    )
  }
}

#Preview {
  TopBar()
}
