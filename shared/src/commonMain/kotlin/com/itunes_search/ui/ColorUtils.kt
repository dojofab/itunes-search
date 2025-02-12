package com.itunes_search.ui

import kotlin.math.pow
import kotlin.math.roundToLong

fun colorToArgb(color: Long): Array<Int> {
    val alpha = (color shr 24 and 0xff).toInt()
    val red = (color shr 16 and 0xff).toInt()
    val green = (color shr 8 and 0xff).toInt()
    val blue = (color and 0xff).toInt()

    return arrayOf(alpha, red, green, blue)
}

// fun colorToHexArgb(color: Long): String {
//    val (alpha, red, green, blue) = colorToArgb(color)
//    return String.format("#%02lX%02lX%02lX%02lX", alpha, red, green, blue)
// }

fun hexArgbToColor(
    hexArgb: String,
    defaultColor: Long = 0
): Long {
    val len = hexArgb.length
    if (!(len == 7 || len == 9 || hexArgb[0] != '#')) {
        return defaultColor
    }

    // Use a long to avoid rollovers on #ffXXXXXX
    var color: Long = hexArgb.substring(1).toLong(16)
    if (len == 7) {
        // Set the alpha value to full opaque
        color = color or 0x00000000ff000000L
    }

    // Truncate to int range but return as long
    return color.toInt().toLong()
}

//
// Refactored from:
// - https://android.googlesource.com/platform/frameworks/base/+/master/graphics/java/android/graphics/Color.java
// - https://android.googlesource.com/platform/frameworks/base/+/master/core/java/com/android/internal/graphics/ColorUtils.java
//

/**
 * Set the alpha component of {@code color} to be {@code alpha}.
 * See: https://android.googlesource.com/platform/frameworks/base/+/master/core/java/com/android/internal/graphics/ColorUtils.java#370
 */
fun setAlphaComponent(
    color: Long,
    alpha: Long
): Long {
    if (alpha < 0 || alpha > 255) {
        throw IllegalArgumentException("alpha must be between 0 and 255.")
    }
    return (color and 0x00ffffff) or (alpha shl 24)
}

fun setAlphaComponent(
    color: Long,
    alpha: Double
): Long = setAlphaComponent(color, (alpha * 255).roundToLong())

/**
 * Convert RGB components to its CIE XYZ representative components.
 * See: https://android.googlesource.com/platform/frameworks/base/+/master/core/java/com/android/internal/graphics/ColorUtils.java#448
 *
 * The resulting XYZ representation will use the D65 illuminant and the CIE
 * 2° Standard Observer (1931).
 *
 *  * outXyz[0] is X [0 ...95.047)
 *  * outXyz[1] is Y [0...100)
 *  * outXyz[2] is Z [0...108.883)
 *
 *
 * @param r      red component value [0..255]
 * @param g      green component value [0..255]
 * @param b      blue component value [0..255]
 * @out outXyz 3-element array which holds the resulting XYZ components
 */
fun rgbToXYZ(
    r: Int,
    g: Int,
    b: Int
): Array<Double> {
    var sr = r / 255.0
    sr = if (sr < 0.04045) sr / 12.92 else ((sr + 0.055) / 1.055).pow(2.4)
    var sg = g / 255.0
    sg = if (sg < 0.04045) sg / 12.92 else ((sg + 0.055) / 1.055).pow(2.4)
    var sb = b / 255.0
    sb = if (sb < 0.04045) sb / 12.92 else ((sb + 0.055) / 1.055).pow(2.4)
    return arrayOf(
        100 * (sr * 0.4124 + sg * 0.3576 + sb * 0.1805),
        100 * (sr * 0.2126 + sg * 0.7152 + sb * 0.0722),
        100 * (sr * 0.0193 + sg * 0.1192 + sb * 0.9505)
    )
}

/**
 * Convert the ARGB color to its CIE XYZ representative components.
 * See: https://android.googlesource.com/platform/frameworks/base/+/master/core/java/com/android/internal/graphics/ColorUtils.java#427
 *
 * <p>The resulting XYZ representation will use the D65 illuminant and the CIE
 * 2° Standard Observer (1931).</p>
 *
 * <ul>
 * <li>outXyz[0] is X [0 ...95.047)</li>
 * <li>outXyz[1] is Y [0...100)</li>
 * <li>outXyz[2] is Z [0...108.883)</li>
 * </ul>
 *
 * @param color  the ARGB color to convert. The alpha component is ignored
 * @out outXyz 3-element array which holds the resulting LAB components
 */
fun colorToXYZ(color: Long): Array<Double> {
    val (_, r, g, b) = colorToArgb(color)
    return rgbToXYZ(r, g, b)
}

/**
 * Returns the luminance of a color as a float between {@code 0.0} and {@code 1.0}.
 * <p>Defined as the Y component in the XYZ representation of {@code color}.</p>
 * See: https://android.googlesource.com/platform/frameworks/base/+/master/core/java/com/android/internal/graphics/ColorUtils.java#79
 */
fun calculateLuminance(color: Long): Double {
    val xyz = colorToXYZ(color)
    // Luminance is the Y component
    return xyz[1] / 100
}

/**
 * Returns a boolean specifying whether to use a dark or light color against the supplied color
 * See: https://android.googlesource.com/platform/frameworks/base.git/+/master/core/java/com/android/internal/util/ContrastColorUtil.java#595
 * See: https://stackoverflow.com/questions/3942878/how-to-decide-font-color-in-white-or-black-depending-on-background-color
 */
fun shouldUseDarkOn(backgroundColor: Long) =
    // Color contrast ratio luminance midpoint, X: 1.05 / (X + 0.05) = (X + 0.05) / 0.05
    // Solved as X = sqrt(.05 * 1.05) - 0.05 = 0.17912878474
    shouldUseDarkOn(backgroundColor, 0.17912878474)

fun shouldUseDarkOn(
    backgroundColor: Long,
    luminanceThreshold: Double
): Boolean = calculateLuminance(backgroundColor) > luminanceThreshold
