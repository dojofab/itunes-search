//
//  DesignTokensExtension.swift
//  iosApp
//
//  Created by Donn Johnson Fabian on 2/14/25.
//  Copyright © 2025 orgName. All rights reserved.
//

import shared

extension DesignTokens {
  static let content = Content.shared
  static let image = Image.shared
  static let icon = Icon.shared
  static let cornerRadius = CornerRadius.shared
  static let spacing = Spacing.shared
}

extension DesignTokens.Icon {
  func iconSize(_ sizePreset: Theme.SizePreset) -> CGFloat {
    switch sizePreset {
    case .xs: return CGFloat(iconSizeXs)
    case .sm: return CGFloat(iconSizeSm)
    case .md: return CGFloat(iconSizeMd)
    case .lg: return CGFloat(iconSizeLg)
    case .xl: return CGFloat(iconSizeXl)
    case .xxl: return CGFloat(iconSizeXxl)
    case .custom(let val): return CGFloat(val)
    }
  }
}
