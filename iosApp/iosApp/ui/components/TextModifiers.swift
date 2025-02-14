import SwiftUI
import shared

struct TextModifier: ViewModifier {
  @Environment(\.contentColor) var contentColor: Color?

  let color: Color?
  let uiFont: UIFont
  let lineSpacing: CGFloat

  func body(content: Content) -> some View {
    content
      .foregroundColor(color ?? contentColor)
      .font(Font(uiFont))
      .lineSpacing(lineSpacing)
      .padding(.vertical, lineSpacing / 2.0)
//      .minimumScaleFactor(0.8)
  }
}

extension TextStyle {
  func textModifier() -> TextModifier {
    TextModifier(color: color, uiFont: uiFont, lineSpacing: lineSpacing)
  }
}

extension Text {
  func styled(
    as type: Typography.TextType = .body,
    sized: Theme.SizePreset = .md,
    color: Color? = nil,
    fontName: String? = nil
  ) -> some View {
    styled(as: TextStyle.with(type: type, sized: sized).copy(color: color, fontName: fontName))
  }

  func styled(as style: TextStyle) -> some View {
    tracking(style.letterSpacing).modifier(style.textModifier())
  }
}
