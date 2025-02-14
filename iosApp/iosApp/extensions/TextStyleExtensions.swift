
import SwiftUI
import shared

extension shared.TextStyle {
  func toTextStyle() -> TextStyle {
    TextStyle.from(self)
  }
}
