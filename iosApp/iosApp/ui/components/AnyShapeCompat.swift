
// Refactored from:
//  - https://forums.swift.org/t/function-that-returns-any-shape-anyshape/35614/3
//  - https://serialcoder.dev/text-tutorials/swiftui/playing-with-swiftui-implementing-a-customizable-and-animatable-circled-checkmark-view/
//

import SwiftUI

@available(iOS, deprecated: 16.0, message: "Use the built-in APIs instead")
struct AnyShapeCompat: Shape {
  private var wrapped: (CGRect) -> Path

  init<S>(_ shape: S) where S: Shape {
    wrapped = shape.path(in:)
  }

  func path(in rect: CGRect) -> Path {
    wrapped(rect)
  }
}
