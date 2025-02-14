import SwiftUI
import RswiftResources
import Factory
import shared

struct AppOutlinedTextField: View {
  @StateObject private var themeManager = Container.shared.themeManager()
  @State private var isFocused = false

  let value: Binding<String>
  let isEnabled: Bool
  let readOnly: Bool
  let textType: Typography.TextType
  let sized: Theme.SizePreset
  let placeholder: String
  let leadingIcon: RswiftResources.ImageResource?
  let trailingIcon: RswiftResources.ImageResource?
  let isError: Bool
  let containterColor: Color?
  let autoCapitalization: UITextAutocapitalizationType?
  let onEditingChanged: ((Bool) -> Void)?
  let onCommit: (() -> Void)?
  let onTrailingIconClick: (() -> Void)?

  init(
    value: Binding<String>,
    isEnabled: Bool = true,
    readOnly: Bool = false,
    textType: Typography.TextType = .body,
    sized: Theme.SizePreset = .md,
    placeholder: String = "",
    leadingIcon: RswiftResources.ImageResource? = nil,
    trailingIcon: RswiftResources.ImageResource? = nil,
    isError: Bool = false,
    containerColor: Color? = nil,
    autoCapitalization: UITextAutocapitalizationType? = .sentences,
    onEditingChanged: ((Bool) -> Void)? = nil,
    onCommit: (() -> Void)? = nil,
    onTrailingIconClick: (() -> Void)? = nil
  ) {
    self.value = value
    self.isEnabled = isEnabled
    self.readOnly = readOnly
    self.textType = textType
    self.sized = sized
    self.placeholder = placeholder
    self.leadingIcon = leadingIcon
    self.trailingIcon = trailingIcon
    self.isError = isError
    self.containterColor = containerColor
    self.autoCapitalization = autoCapitalization
    self.onEditingChanged = onEditingChanged
    self.onCommit = onCommit
    self.onTrailingIconClick = onTrailingIconClick
  }

  var body: some View {
    TextField(
      placeholder,
      text: value,
      onEditingChanged: { active in
        isFocused = active
        onEditingChanged?(active)
      },
      onCommit: {
        isFocused = false
        onCommit?()
      }
    )
      .autocapitalization(autoCapitalization ?? .sentences)
      .disabled(!isEnabled)
      .outlinedTextField(
        theme: themeManager.theme,
        isEnabled: isEnabled,
        readOnly: readOnly,
        textType: textType,
        sized: sized,
        leadingIcon: leadingIcon,
        trailingIcon: trailingIcon,
        isFocused: isFocused,
        isError: isError,
        containerColor: containterColor,
        onTrailingIconClick: onTrailingIconClick
      )
  }
}

struct AppOutlinedTextField_Previews: PreviewProvider {
  static var previews: some View {
    VStack {
      AppOutlinedTextField(value: .constant(""))

      AppOutlinedTextField(value: .constant("Some text"))

      AppOutlinedTextField(
        value: .constant("Some text"),
        leadingIcon: R.image.ic_search
      )

      AppOutlinedTextField(
        value: .constant("Some text"),
        trailingIcon: R.image.ic_search
      )
    }
  }
}
