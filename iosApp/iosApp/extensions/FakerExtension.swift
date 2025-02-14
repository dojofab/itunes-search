//
//  FakerExtension.swift
//  iosApp
//
//  Created by Donn Johnson Fabian on 2/14/25.
//  Copyright © 2025 orgName. All rights reserved.
//

import shared

extension ContentGenerator {
  func build() -> ContentModel {
    build(overrides: [:])
  }
  
  func buildMany(count: Int, overrides: [String: Any] = [:]) -> [ContentModel] {
    buildMany(count: Int32(count), overrides: overrides) as! [ContentModel]
  }
}
