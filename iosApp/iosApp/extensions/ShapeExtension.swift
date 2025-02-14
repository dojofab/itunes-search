//
//  ShapeExtension.swift
//  iosApp
//
//  Created by Donn Johnson Fabian on 2/14/25.
//  Copyright © 2025 orgName. All rights reserved.
//

import SwiftUI

extension Shape {
  func eraseToAnyShape() -> AnyShapeCompat {
    if let shape = self as? AnyShapeCompat {
      return shape
    }

    return AnyShapeCompat(self)
  }
}
