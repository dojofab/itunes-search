import SwiftUI
import shared

struct TextStyle {
  let color: Color?
  let fontSize: Double
  let fontWeight: FontWeight
  let letterSpacing: Double
  let lineHeight: Double?
  let fontName: String?

  func copy(
    color: Color? = nil,
    fontSize: Double? = nil,
    fontWeight: FontWeight? = nil,
    letterSpacing: Double? = nil,
    lineHeight: Double? = nil,
    fontName: String? = nil
  ) -> TextStyle {
    TextStyle(
      color: color ?? self.color,
      fontSize: fontSize ?? self.fontSize,
      fontWeight: fontWeight ?? self.fontWeight,
      letterSpacing: letterSpacing ?? self.letterSpacing,
      lineHeight: lineHeight ?? self.lineHeight,
      fontName: fontName ?? self.fontName
    )
  }

  static func from(_ shared: shared.TextStyle) -> TextStyle {
    var lineHeight: Double?
    if let sharedLineHeight = shared.lineHeight {
      lineHeight = Double(truncating: sharedLineHeight)
    }

    return TextStyle(
      color: nil,
      fontSize: shared.fontSize,
      fontWeight: shared.fontWeight,
      letterSpacing: shared.letterSpacing,
      lineHeight: lineHeight,
      fontName: nil
    )
  }

  static func with(type: Typography.TextType, sized size: Theme.SizePreset) -> TextStyle {
    switch type {
    case .display: return displaySized(size)
    case .headline: return headlineSized(size)
    case .body: return bodySized(size)
    case .title: return titleSized(size)
    case .label: return labelSized(size)
    }
  }

  static func displaySized(_ size: Theme.SizePreset) -> TextStyle {
    switch size {
    case .md: return Typography.shared.displayMedium.toTextStyle()
    case .lg, .xl, .xxl: return Typography.shared.displayLarge.toTextStyle()
    case .sm, .xs: return Typography.shared.displaySmall.toTextStyle()
    case .custom(let size):
      return Typography.shared.displayMedium.toTextStyle().copy(fontSize: size, lineHeight: nil)
    }
  }

  static func headlineSized(_ size: Theme.SizePreset) -> TextStyle {
    switch size {
    case .md: return Typography.shared.headlineMedium.toTextStyle()
    case .lg, .xl, .xxl: return Typography.shared.headlineLarge.toTextStyle()
    case .sm, .xs: return Typography.shared.headlineSmall.toTextStyle()
    case .custom(let size):
      return Typography.shared.headlineMedium.toTextStyle().copy(fontSize: size, lineHeight: nil)
    }
  }

  static func bodySized(_ size: Theme.SizePreset) -> TextStyle {
    switch size {
    case .md: return Typography.shared.bodyMedium.toTextStyle()
    case .lg, .xl, .xxl: return Typography.shared.bodyLarge.toTextStyle()
    case .sm, .xs: return Typography.shared.bodySmall.toTextStyle()
    case .custom(let size):
      return Typography.shared.bodyMedium.toTextStyle().copy(fontSize: size, lineHeight: nil)
    }
  }

  static func titleSized(_ size: Theme.SizePreset) -> TextStyle {
    switch size {
    case .md: return Typography.shared.titleMedium.toTextStyle()
    case .lg, .xl, .xxl: return Typography.shared.titleLarge.toTextStyle()
    case .sm, .xs: return Typography.shared.titleSmall.toTextStyle()
    case .custom(let size):
      return Typography.shared.titleMedium.toTextStyle().copy(fontSize: size, lineHeight: nil)
    }
  }

  static func labelSized(_ size: Theme.SizePreset) -> TextStyle {
    switch size {
    case .md: return Typography.shared.labelMedium.toTextStyle()
    case .lg, .xl, .xxl: return Typography.shared.labelLarge.toTextStyle()
    case .sm, .xs: return Typography.shared.labelSmall.toTextStyle()
    case .custom(let size):
      return Typography.shared.labelMedium.toTextStyle().copy(fontSize: size, lineHeight: nil)
    }
  }

  var uiFont: UIFont {
    if let fontName = fontName {
      return UIFont(name: fontName, size: fontSize) ?? UIFont.systemFont(ofSize: fontSize)
    } else {
      switch fontWeight {
      case .normal, .medium: return R.font.latoRegular(size: fontSize) ?? UIFont.systemFont(ofSize: fontSize)
      case .bold: return R.font.latoBold(size: fontSize) ?? UIFont.boldSystemFont(ofSize: fontSize)
      case .light: return R.font.latoLight(size: fontSize) ?? UIFont.systemFont(ofSize: fontSize)
      case .black: return R.font.latoBlack(size: fontSize) ?? UIFont.boldSystemFont(ofSize: fontSize)
      case .thin: return R.font.latoHairline(size: fontSize) ?? UIFont.systemFont(ofSize: fontSize)
      default: return R.font.latoRegular(size: fontSize) ?? UIFont.systemFont(ofSize: fontSize)
      }
    }
  }

  var font: Font {
    Font(uiFont)
  }

  var lineSpacing: CGFloat {
    var spacing: CGFloat = 0

    // https://stackoverflow.com/questions/61705184/how-to-set-line-height-for-a-single-line-text-in-swiftui
    if let lineHeight = lineHeight {
      spacing = lineHeight - uiFont.lineHeight
    }

    return spacing
  }
}
