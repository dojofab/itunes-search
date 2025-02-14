// Full Specs here:
//  https://m3.material.io/components/text-fields/specs

import SwiftUI
import Factory
import RswiftResources
import shared

private let kMinHeight: CGFloat = 56
private let kIconPadding: CGFloat = 12
private let kTextPadding: CGFloat = 16

struct AppTextFieldModifier<LeadingIcon, TrailingIcon>: ViewModifier where LeadingIcon: View, TrailingIcon: View {
  @Environment(\.contentColor) var contentColor: Color?
  @StateObject private var themeManager = Container.shared.themeManager()

  let isEnabled: Bool
  let readOnly: Bool
  let font: Font
  let lineSpacing: CGFloat
  let sized: Theme.SizePreset
  @ViewBuilder let leadingIcon: () -> LeadingIcon
  @ViewBuilder let trailingIcon: () -> TrailingIcon
  let isFocused: Bool
  let isError: Bool
  let focusedBorderColor: Color?
  let unfocusedBorderColor: Color?
  let textColor: Color?
  let containerColor: Color?
  let disabledBorderColor: Color?
  let disabledTextColor: Color?
  let disabledTrailingColor: Color?

  private var stateTextColor: Color {
    isEnabled ?
      (textColor ?? themeManager.theme.onSurfaceColor) :
    (disabledTextColor ?? themeManager.theme.onSurfaceColor.opacity(DesignTokens.content.DisabledContentOpacity))
  }

  private var stateContainerColor: Color {
    containerColor ?? themeManager.theme.surfaceColor
  }

  private var stateBorderColor: Color {
    isFocused ?
      (focusedBorderColor ?? themeManager.theme.primaryColor) :
    (unfocusedBorderColor ?? Color.clear)
  }

  private var stateTrailingIconColor: Color {
    isEnabled ?
      (textColor ?? themeManager.theme.onSurfaceColor) :
    (disabledTrailingColor ?? themeManager.theme.onSurfaceColor.opacity(DesignTokens.content.DisabledContentOpacity))
  }

  init(
    isEnabled: Bool = true,
    readOnly: Bool = false,
    textType: Typography.TextType = .body,
    sized: Theme.SizePreset = .md,
    @ViewBuilder leadingIcon: @escaping () -> LeadingIcon,
    @ViewBuilder trailingIcon: @escaping () -> TrailingIcon,
    isFocused: Bool = false,
    isError: Bool = false,
    focusedBorderColor: Color? = nil,
    unfocusedBorderColor: Color? = nil,
    textColor: Color? = nil,
    containerColor: Color? = nil,
    disabledBorderColor: Color? = nil,
    disabledTextColor: Color? = nil,
    disabledTrailingColor: Color? = nil,
    uiFont: UIFont? = nil
  ) {
    self.isEnabled = isEnabled
    self.readOnly = readOnly
    self.sized = sized
    self.leadingIcon = leadingIcon
    self.trailingIcon = trailingIcon
    self.isFocused = isFocused
    self.isError = isError
    self.focusedBorderColor = focusedBorderColor
    self.unfocusedBorderColor = unfocusedBorderColor
    self.textColor = textColor
    self.containerColor = containerColor
    self.disabledBorderColor = disabledBorderColor
    self.disabledTextColor = disabledTextColor
    self.disabledTrailingColor = disabledTrailingColor

    let textStyle = TextStyle.with(type: textType, sized: sized)
    font = textStyle.font
    lineSpacing = textStyle.lineSpacing
  }
  
  func body(content: Content) -> some View {
    HStack(spacing: 0) {
      leadingIcon()
        .padding(.leading, CGFloat(kIconPadding))
      content
        .foregroundColor(stateTextColor)
        .font(font)
        .lineSpacing(lineSpacing)
        .padding(.vertical, lineSpacing / 2.0)
        .padding(.horizontal, CGFloat(kTextPadding))
      trailingIcon()
        .foregroundColor(stateTrailingIconColor)
        .padding(.trailing, CGFloat(kIconPadding))
    }
      .frame(minHeight: kMinHeight)
      .background(textFieldShape.fill(stateContainerColor))
      .overlay(
        textFieldShape
          .stroke(stateBorderColor)
      )
  }
}

extension AppTextFieldModifier where LeadingIcon == EmptyView {
  init(
    isEnabled: Bool = true,
    readOnly: Bool = false,
    textType: Typography.TextType = .body,
    sized: Theme.SizePreset = .md,
    @ViewBuilder trailingIcon: @escaping () -> TrailingIcon,
    isFocused: Bool = false,
    isError: Bool = false,
    focusedBorderColor: Color? = nil,
    unfocusedBorderColor: Color? = nil,
    textColor: Color? = nil,
    containerColor: Color? = nil,
    disabledBorderColor: Color? = nil,
    disabledTextColor: Color? = nil,
    disabledTrailingColor: Color? = nil
  ) {
    self.init(
      isEnabled: isEnabled,
      readOnly: readOnly,
      textType: textType,
      sized: sized,
      leadingIcon: {},
      trailingIcon: trailingIcon,
      isFocused: isFocused,
      isError: isError,
      focusedBorderColor: focusedBorderColor,
      unfocusedBorderColor: unfocusedBorderColor,
      textColor: textColor,
      containerColor: containerColor,
      disabledBorderColor: disabledBorderColor,
      disabledTextColor: disabledTextColor,
      disabledTrailingColor: disabledTrailingColor
    )
  }
}

extension AppTextFieldModifier where TrailingIcon == EmptyView {
  init(
    isEnabled: Bool = true,
    readOnly: Bool = false,
    textType: Typography.TextType = .body,
    sized: Theme.SizePreset = .md,
    @ViewBuilder leadingIcon: @escaping () -> LeadingIcon,
    isFocused: Bool = false,
    isError: Bool = false,
    focusedBorderColor: Color? = nil,
    unfocusedBorderColor: Color? = nil,
    textColor: Color? = nil,
    containerColor: Color? = nil,
    disabledBorderColor: Color? = nil,
    disabledTextColor: Color? = nil,
    disabledTrailingColor: Color? = nil
  ) {
    self.init(
      isEnabled: isEnabled,
      readOnly: readOnly,
      textType: textType,
      sized: sized,
      leadingIcon: leadingIcon,
      trailingIcon: {},
      isFocused: isFocused,
      isError: isError,
      focusedBorderColor: focusedBorderColor,
      unfocusedBorderColor: unfocusedBorderColor,
      textColor: textColor,
      containerColor: containerColor,
      disabledBorderColor: disabledBorderColor,
      disabledTextColor: disabledTextColor,
      disabledTrailingColor: disabledTrailingColor
    )
  }
}

extension AppTextFieldModifier where LeadingIcon == EmptyView, TrailingIcon == EmptyView {
  init(
    isEnabled: Bool = true,
    readOnly: Bool = false,
    textType: Typography.TextType = .body,
    sized: Theme.SizePreset = .md,
    isFocused: Bool = false,
    isError: Bool = false,
    focusedBorderColor: Color? = nil,
    unfocusedBorderColor: Color? = nil,
    textColor: Color? = nil,
    containerColor: Color? = nil,
    disabledBorderColor: Color? = nil,
    disabledTextColor: Color? = nil,
    disabledTrailingColor: Color? = nil
  ) {
    self.init(
      isEnabled: isEnabled,
      readOnly: readOnly,
      textType: textType,
      sized: sized,
      leadingIcon: {},
      trailingIcon: {},
      isFocused: isFocused,
      isError: isError,
      focusedBorderColor: focusedBorderColor,
      unfocusedBorderColor: unfocusedBorderColor,
      textColor: textColor,
      containerColor: containerColor,
      disabledBorderColor: disabledBorderColor,
      disabledTextColor: disabledTextColor,
      disabledTrailingColor: disabledTrailingColor
    )
  }
}

extension View {
  func styledTextField(
    theme: Theme,
    isEnabled: Bool = true,
    readOnly: Bool = false,
    textType: Typography.TextType = .body,
    sized: Theme.SizePreset = .md,
    leadingIcon: RswiftResources.ImageResource? = nil,
    trailingIcon: RswiftResources.ImageResource? = nil,
    isFocused: Bool = false,
    isError: Bool = false,
    focusedBorderColor: Color? = nil,
    unfocusedBorderColor: Color? = nil,
    textColor: Color? = nil,
    containerColor: Color? = nil,
    disabledBorderColor: Color? = nil,
    disabledTextColor: Color? = nil,
    disabledTrailingColor: Color? = nil
  ) -> some View {
    modifier(AppTextFieldModifier(
      isEnabled: isEnabled,
      readOnly: readOnly,
      textType: textType,
      sized: sized,
      leadingIcon: {
        if let leadingIcon = leadingIcon {
          Image(leadingIcon)
            .renderingMode(.template)
            .foregroundColor(theme.surfaceVariantColor)
        }
      },
      trailingIcon: {
        if let trailingIcon = trailingIcon {
          Image(trailingIcon)
            .renderingMode(.template)
            .foregroundColor(theme.surfaceVariantColor)
        }
      },
      isFocused: isFocused,
      isError: isError,
      focusedBorderColor: focusedBorderColor,
      unfocusedBorderColor: unfocusedBorderColor,
      textColor: textColor,
      containerColor: containerColor,
      disabledBorderColor: disabledBorderColor,
      disabledTextColor: disabledTextColor,
      disabledTrailingColor: disabledTrailingColor
    ))
  }

  func outlinedTextField(
    theme: Theme,
    isEnabled: Bool = true,
    readOnly: Bool = false,
    textType: Typography.TextType = .body,
    sized: Theme.SizePreset = .md,
    leadingIcon: RswiftResources.ImageResource? = nil,
    trailingIcon: RswiftResources.ImageResource? = nil,
    isFocused: Bool = false,
    isError: Bool = false,
    containerColor: Color? = nil,
    onTrailingIconClick: (() -> Void)? = nil
  ) -> some View {
    modifier(AppTextFieldModifier(
      isEnabled: isEnabled,
      readOnly: readOnly,
      textType: textType,
      sized: sized,
      leadingIcon: {
        if let leadingIcon = leadingIcon {
          Image(leadingIcon)
            .renderingMode(.template)
            .foregroundColor(theme.surfaceVariantColor)
            .frame(width: DesignTokens.icon.iconSize(sized), height: DesignTokens.icon.iconSize(sized))
        }
      },
      trailingIcon: {
        if let trailingIcon = trailingIcon {
          Image(trailingIcon)
            .renderingMode(.template)
            .foregroundColor(theme.surfaceVariantColor)
            .frame(width: DesignTokens.icon.iconSize(sized), height: DesignTokens.icon.iconSize(sized))
            .onTapGesture {
              onTrailingIconClick?()
            }
        }
      },
      isFocused: isFocused,
      isError: isError,
      containerColor: containerColor
    ))
  }
}
