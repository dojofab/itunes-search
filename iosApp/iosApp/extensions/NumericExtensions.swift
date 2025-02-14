import SwiftUI

extension Int64 {
  func argbToColor() -> Color {
    let alpha = Double((self & 0xFF000000) >> 24) / 255
    let red = Double((self & 0x00FF0000) >> 16) / 255
    let green = Double((self & 0x0000FF00) >> 8) / 255
    let blue = Double(self & 0x000000FF) / 255

    return Color(red: red, green: green, blue: blue, opacity: alpha)
  }
}
