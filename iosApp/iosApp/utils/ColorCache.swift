import SwiftUI

class ColorCache {
  private var map: [Int64: Color] = Dictionary.init(minimumCapacity: 32)

  subscript(colorCode: Int64) -> Color {
    guard let color = map[colorCode] else {
      let newColor = colorCode.argbToColor()
      map[colorCode] = newColor
      return newColor
    }

    return color
  }
}

let colorCache = ColorCache()
