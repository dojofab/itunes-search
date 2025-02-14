//
//  TopBar.swift
//  iosApp
//
//  Created by Donn Johnson Fabian on 2/13/25.
//  Copyright © 2025 orgName. All rights reserved.
//

import SwiftUI

struct TopBar: View {
  var body: some View {
    HStack {
      Text(R.string.localizable.app_name())
    }
    .frame(maxWidth: .infinity)
  }
}

#Preview {
  TopBar()
}
