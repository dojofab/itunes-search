//
//  SearchBar.swift
//  iosApp
//
//  Created by Donn Johnson Fabian on 2/14/25.
//  Copyright © 2025 orgName. All rights reserved.
//

import SwiftUI

struct SearchBar: View {
  var searchValue: Binding<String>
  
  var body: some View {
    AppOutlinedTextField(
      value: searchValue,
      placeholder: R.string.localizable.search_placeholder()
    )
  }
}

#Preview {
  SearchBar(
    searchValue: .constant("Test")
  )
}
