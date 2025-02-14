import SwiftUI
import shared

typealias Theme = shared.Theme

// MARK: - Sizing and Presets

extension Theme {
  enum SizePreset {
    // swiftlint:disable:next identifier_name
    case xs, sm, md, lg, xl, xxl, custom(Double)

    var increment: Self {
      switch self {
      case .xs:
        return .sm
      case .sm:
        return .md
      case .md:
        return .lg
      case .lg:
        return .xl
      case .xl:
        return .xxl
      case .xxl:
        return .xxl
      case .custom(let double):
        return .custom(double + 1.0)
      }
    }

    var decrement: Self {
      switch self {
      case .xs:
        return .xs
      case .sm:
        return .xs
      case .md:
        return .sm
      case .lg:
        return .md
      case .xl:
        return .lg
      case .xxl:
        return .xl
      case .custom(let double):
        return .custom(double - 1.0)
      }
    }
  }
}

// MARK: - Colors
extension Theme {
  var primaryColor: Color {
    colorCache[colors.primary]
  }
  var onPrimaryColor: Color {
    colorCache[colors.onPrimary]
  }
  var primaryContainerColor: Color {
    colorCache[colors.primaryContainer]
  }
  var onPrimaryContainerColor: Color {
    colorCache[colors.onPrimaryContainer]
  }
  var inversePrimaryColor: Color {
    colorCache[colors.inversePrimary]
  }
  var secondaryColor: Color {
    colorCache[colors.secondary]
  }
  var onSecondaryColor: Color {
    colorCache[colors.onSecondary]
  }
  var secondaryContainerColor: Color {
    colorCache[colors.secondaryContainer]
  }
  var onSecondaryContainerColor: Color {
    colorCache[colors.onSecondaryContainer]
  }
  var tertiaryColor: Color {
    colorCache[colors.tertiary]
  }
  var onTertiaryColor: Color {
    colorCache[colors.onTertiary]
  }
  var tertiaryContainerColor: Color {
    colorCache[colors.tertiaryContainer]
  }
  var onTertiaryContainerColor: Color {
    colorCache[colors.onTertiaryContainer]
  }
  var backgroundColor: Color {
    colorCache[colors.background]
  }
  var onBackgroundColor: Color {
    colorCache[colors.onBackground]
  }
  var onBackgroundMutedColor: Color {
    colorCache[onBackgroundMuted]
  }
  var surfaceColor: Color {
    colorCache[colors.surface]
  }
  var onSurfaceColor: Color {
    colorCache[colors.onSurface]
  }
  var surfaceVariantColor: Color {
    colorCache[colors.surfaceVariant]
  }
  var onSurfaceVariantColor: Color {
    colorCache[colors.onSurfaceVariant]
  }
  var surfaceTintColor: Color {
    colorCache[colors.surfaceTint]
  }
  var inverseSurfaceColor: Color {
    colorCache[colors.inverseSurface]
  }
  var inverseOnSurfaceColor: Color {
    colorCache[colors.inverseOnSurface]
  }
  var errorColor: Color {
    colorCache[colors.error]
  }
  var onErrorColor: Color {
    colorCache[colors.onError]
  }
  var errorContainerColor: Color {
    colorCache[colors.errorContainer]
  }
  var onErrorContainerColor: Color {
    colorCache[colors.onErrorContainer]
  }
  var outlineColor: Color {
    colorCache[colors.outline]
  }
  var gradientBackgroundColor: Color {
    colorCache[colors.gradientBackground]
  }
  var scrimColor: Color {
    colorCache[colors.scrim]
  }
  var placeholderColor: Color {
    colorCache[colors.placeholder]
  }
  var shimmerColor: Color {
    colorCache[colors.shimmer]
  }
  var whiteColor: Color {
    colorCache[AppColors.shared.White]
  }
  var darkTextColor: Color {
    colorCache[AppColors.shared.DarkText]
  }
}

// MARK: - Color Utils
extension Theme {
  // swiftlint:disable:next cyclomatic_complexity
  func contentColorFor(_ color: Color, fallback: Color? = nil) -> Color {
    if color == backgroundColor {
      return onBackgroundColor
    }
    if color == surfaceColor {
      return onSurfaceColor
    }
    if color == surfaceVariantColor {
      return onSurfaceVariantColor
    }
    if color == inverseSurfaceColor {
      return inverseOnSurfaceColor
    }
    if color == primaryContainerColor {
      return onPrimaryContainerColor
    }
    if color == secondaryContainerColor {
      return onSecondaryContainerColor
    }
    if color == tertiaryContainerColor {
      return onTertiaryContainerColor
    }
    if color == errorContainerColor {
      return onErrorContainerColor
    }
    if color == primaryColor {
      return onPrimaryColor
    }
    if color == secondaryColor {
      return onSecondaryColor
    }
    if color == tertiaryColor {
      return onTertiaryColor
    }
    if color == errorColor {
      return onErrorColor
    }

    return fallback ?? onBackgroundColor
  }
}
