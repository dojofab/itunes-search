
import SwiftUI
import Factory
import shared

struct HorizontalDivider: View {
  @StateObject private var themeManager = Container.shared.themeManager()
  
  let thickness = DesignTokens.content.DividerThickness

  var body: some View {
    Divider()
      .frame(height: thickness)
      .overlay(themeManager.theme.onSurfaceColor)
  }
}

struct HorizontalDivider_Previews: PreviewProvider {
  static var previews: some View {
    HorizontalDivider()
  }
}
