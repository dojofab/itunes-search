//
//  PriceView.swift
//  iosApp
//
//  Created by Donn Johnson Fabian on 2/14/25.
//  Copyright © 2025 orgName. All rights reserved.
//

import SwiftUI
import Factory

struct PriceView: View {
  @StateObject private var themeManager = Container.shared.themeManager()
  
  let price: String
  let currency: String
  
  var body: some View {
    Surface(
      color: Color.red,
      shape: roundedContainerShape
    ){
      Text("\(price) \(currency)")
        .styled(sized: .sm, color: themeManager.theme.onBackgroundColor)
    }
  }
}

#Preview {
  PriceView(
    price: "1.00",
    currency: "USD"
  )
}
