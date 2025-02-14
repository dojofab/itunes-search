//
//  ItemView.swift
//  iosApp
//
//  Created by Donn Johnson Fabian on 2/14/25.
//  Copyright © 2025 orgName. All rights reserved.
//

import SwiftUI
import Factory

struct ItemView<ValueView: View>: View
where ValueView: View{
  @StateObject private var themeManager = Container.shared.themeManager()
  
  let label: String
  @ViewBuilder var value: ValueView
  
  init(
    label: String,
    @ViewBuilder value: () -> ValueView
  ) {
    self.label = label
    self.value = value()
  }
  
  var body: some View {
    HStack {
      Text(label)
        .styled(sized: .sm, color: themeManager.theme.onBackgroundMutedColor)
      
      Spacer()
      
      value
    }
  }
}

#Preview {
  ItemView(
    label: "Test",
    value: {
      Text("Test")
    }
  )
}
