//  Refactored from:
//  - https://github.com/android/compose-samples/blob/main/Jetsnack/app/src/main/java/com/example/jetsnack/ui/components/Surface.kt
//  - https://developer.android.com/reference/kotlin/androidx/compose/material/package-summary#surfaces-and-layout
//  - https://android.googlesource.com/platform/frameworks/support/+/refs/heads/androidx-main/compose/material3/material3/src/commonMain/kotlin/androidx/compose/material3/Surface.kt
//

import SwiftUI
import Factory
import shared

struct Surface<Content: View>: View {
  @Environment(\.contentColor) var defaultContentColor: Color?
  @StateObject private var themeManager = Container.shared.themeManager()

  let alignment: Alignment
  let color: Color?
  let contentColor: Color?
  let borderWidth: CGFloat
  let borderColor: Color
  let shape: AnyShapeCompat
  @ViewBuilder let content: () -> Content

  init(
    alignment: Alignment = .top,
    color: Color? = nil,
    contentColor: Color? = nil,
    borderWidth: CGFloat? = nil,
    borderColor: Color? = nil,
    shape: AnyShapeCompat = AnyShapeCompat(Rectangle()),
    @ViewBuilder content: @escaping () -> Content
  ) {
    self.alignment = alignment
    self.color = color
    self.contentColor = contentColor
    self.borderWidth = borderWidth ?? 0.0
    self.borderColor = borderColor ?? Color.clear
    self.shape = shape
    self.content = content
  }

  var body: some View {
    let actualColor = color ?? themeManager.theme.backgroundColor
    return ZStack(alignment: alignment, content: content)
      .background(
        shape
          .stroke(borderColor, lineWidth: borderWidth)
          .background(shape.fill(actualColor))
      )
      .clipShape(shape)
      .contentColor(resolveContentColor(color: actualColor, contentColor: contentColor))
  }

  private func resolveContentColor(color: Color, contentColor: Color?) -> Color {
    if let contentColor = contentColor {
      return contentColor
    }

    return themeManager.theme.contentColorFor(color, fallback: defaultContentColor)
  }
}

#Preview {
      Surface(
        color: Color.green,
        contentColor: .yellow,
        borderWidth: 10,
        borderColor: Color.red,
        shape: roundedContainerShape
      ) {
        Text("Sample Content")
      }
}
