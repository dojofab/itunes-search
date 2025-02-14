package com.itunes_search.design.palettes

// Color palette based on Tailwind colors:
//  https://tailwindcss.com/docs/customizing-colors
internal object TailwindColorPalette : TonalColorPalette {
    const val SWATCH_NAME_SLATE = "slate"
    const val SWATCH_NAME_GRAY = "gray"
    const val SWATCH_NAME_ZINC = "zinc"
    const val SWATCH_NAME_NEUTRAL = "neutral"
    const val SWATCH_NAME_STONE = "stone"
    const val SWATCH_NAME_RED = "red"
    const val SWATCH_NAME_ORANGE = "orange"
    const val SWATCH_NAME_AMBER = "amber"
    const val SWATCH_NAME_YELLOW = "yellow"
    const val SWATCH_NAME_LIME = "lime"
    const val SWATCH_NAME_GREEN = "green"
    const val SWATCH_NAME_EMERALD = "emerald"
    const val SWATCH_NAME_TEAL = "teal"
    const val SWATCH_NAME_CYAN = "cyan"
    const val SWATCH_NAME_SKY = "sky"
    const val SWATCH_NAME_BLUE = "blue"
    const val SWATCH_NAME_INDIGO = "indigo"
    const val SWATCH_NAME_VIOLET = "violet"
    const val SWATCH_NAME_PURPLE = "purple"
    const val SWATCH_NAME_FUCHSIA = "fuchsia"
    const val SWATCH_NAME_PINK = "pink"
    const val SWATCH_NAME_ROSE = "rose"

    override val swatches =
        mapOf(
            ColorSwatch(
                SWATCH_NAME_SLATE,
                50 to 0xfff8fafc,
                100 to 0xfff1f5f9,
                200 to 0xffe2e8f0,
                300 to 0xffcbd5e1,
                400 to 0xff94a3b8,
                500 to 0xff64748b,
                600 to 0xff475569,
                700 to 0xff334155,
                800 to 0xff1e293b,
                900 to 0xff0f172a
            ).asNamedPair(),
            ColorSwatch(
                SWATCH_NAME_GRAY,
                50 to 0xfff9fafb,
                100 to 0xfff3f4f6,
                200 to 0xffe5e7eb,
                300 to 0xffd1d5db,
                400 to 0xff9ca3af,
                500 to 0xff6b7280,
                600 to 0xff4b5563,
                700 to 0xff374151,
                800 to 0xff1f2937,
                900 to 0xff111827
            ).asNamedPair(),
            ColorSwatch(
                SWATCH_NAME_ZINC,
                50 to 0xfffafafa,
                100 to 0xfff4f4f5,
                200 to 0xffe4e4e7,
                300 to 0xffd4d4d4,
                400 to 0xffa1a1aa,
                500 to 0xff71717a,
                600 to 0xff52525b,
                700 to 0xff3f3f46,
                800 to 0xff27272a,
                900 to 0xff18181b
            ).asNamedPair(),
            ColorSwatch(
                SWATCH_NAME_NEUTRAL,
                50 to 0xfffafafa,
                100 to 0xfff5f5f5,
                200 to 0xffe5e5e5,
                300 to 0xffd4d4d4,
                400 to 0xffa3a3a3,
                500 to 0xff737373,
                600 to 0xff525252,
                700 to 0xff404040,
                800 to 0xff262626,
                900 to 0xff171717
            ).asNamedPair(),
            ColorSwatch(
                SWATCH_NAME_STONE,
                50 to 0xfffafaf9,
                100 to 0xfff5f5f4,
                200 to 0xffe7e5e4,
                300 to 0xffd6d3d1,
                400 to 0xffa8a29e,
                500 to 0xff78716c,
                600 to 0xff57534e,
                700 to 0xff44403c,
                800 to 0xff292524,
                900 to 0xff1c1917
            ).asNamedPair(),
            ColorSwatch(
                SWATCH_NAME_RED,
                50 to 0xfffef2f2,
                100 to 0xfffee2e2,
                200 to 0xfff297a2,
                300 to 0xffea6d7e,
                400 to 0xfff87171,
                500 to 0xffef4444,
                600 to 0xffdc2626,
                700 to 0xffdd0d3c,
                800 to 0xffd00036,
                900 to 0xffc20029
            ).asNamedPair(),
            ColorSwatch(
                SWATCH_NAME_ORANGE,
                50 to 0xfffff7ed,
                100 to 0xffffedd5,
                200 to 0xfffed7aa,
                300 to 0xfffdba74,
                400 to 0xfffb923c,
                500 to 0xfff97316,
                600 to 0xffea580c,
                700 to 0xffc2410c,
                800 to 0xff9a3412,
                900 to 0xff7c2d12
            ).asNamedPair(),
            ColorSwatch(
                SWATCH_NAME_AMBER,
                50 to 0xfffffbeb,
                100 to 0xfffef3c7,
                200 to 0xfffde68a,
                300 to 0xfffcd34d,
                400 to 0xfffbbf24,
                500 to 0xfff59e0b,
                600 to 0xffd97706,
                700 to 0xffb45309,
                800 to 0xff92400e,
                900 to 0xff78350f
            ).asNamedPair(),
            ColorSwatch(
                SWATCH_NAME_YELLOW,
                50 to 0xfffefce8,
                100 to 0xfffef9c3,
                200 to 0xfffef08a,
                300 to 0xfffde047,
                400 to 0xfffacc15,
                500 to 0xffeab308,
                600 to 0xffca8a04,
                700 to 0xffa16207,
                800 to 0xff854d0e,
                900 to 0xff713f12
            ).asNamedPair(),
            ColorSwatch(
                SWATCH_NAME_LIME,
                50 to 0xfff7fee7,
                100 to 0xffecfccb,
                200 to 0xffd9f99d,
                300 to 0xffbef264,
                400 to 0xffa3e635,
                500 to 0xff84cc16,
                600 to 0xff65a30d,
                700 to 0xff4d7c0f,
                800 to 0xff3f6212,
                900 to 0xff365314
            ).asNamedPair(),
            ColorSwatch(
                SWATCH_NAME_GREEN,
                50 to 0xfff0fdf4,
                100 to 0xffdcfce7,
                200 to 0xffbbf7d0,
                300 to 0xff86efac,
                400 to 0xff4ade80,
                500 to 0xff22c55e,
                600 to 0xff16a34a,
                700 to 0xff15803d,
                800 to 0xff166534,
                900 to 0xff14532d
            ).asNamedPair(),
            ColorSwatch(
                SWATCH_NAME_EMERALD,
                50 to 0xffecfdf5,
                100 to 0xffd1fae5,
                200 to 0xffa7f3d0,
                300 to 0xff6ee7b7,
                400 to 0xff34d399,
                500 to 0xff10b981,
                600 to 0xff059669,
                700 to 0xff047857,
                800 to 0xff065f46,
                900 to 0xff064e3b
            ).asNamedPair(),
            ColorSwatch(
                SWATCH_NAME_TEAL,
                50 to 0xfff0fdfa,
                100 to 0xffccfbf1,
                200 to 0xff99f6e4,
                300 to 0xff5eead4,
                400 to 0xff2dd4bf,
                500 to 0xff14b8a6,
                600 to 0xff0d9488,
                700 to 0xff0f766e,
                800 to 0xff115e59,
                900 to 0xff134e4a
            ).asNamedPair(),
            ColorSwatch(
                SWATCH_NAME_CYAN,
                50 to 0xffecfeff,
                100 to 0xffcffafe,
                200 to 0xffa5f3fc,
                300 to 0xff67e8f9,
                400 to 0xff22d3ee,
                500 to 0xff06b6d4,
                600 to 0xff0891b2,
                700 to 0xff0e7490,
                800 to 0xff155e75,
                900 to 0xff164e63
            ).asNamedPair(),
            ColorSwatch(
                SWATCH_NAME_SKY,
                50 to 0xfff0f9ff,
                100 to 0xffe0f2fe,
                200 to 0xffbae6fd,
                300 to 0xff7dd3fc,
                400 to 0xff38bdf8,
                500 to 0xff0ea5e9,
                600 to 0xff0284c7,
                700 to 0xff0369a1,
                800 to 0xff075985,
                900 to 0xff0c4a6e
            ).asNamedPair(),
            ColorSwatch(
                SWATCH_NAME_BLUE,
                50 to 0xffeff6ff,
                100 to 0xffdbeafe,
                200 to 0xffbfdbfe,
                300 to 0xff93c5fd,
                400 to 0xff60a5fa,
                500 to 0xff3b82f6,
                600 to 0xff2563eb,
                700 to 0xff1d4ed8,
                800 to 0xff1e40af,
                900 to 0xff1e3a8a
            ).asNamedPair(),
            ColorSwatch(
                SWATCH_NAME_INDIGO,
                50 to 0xffeef2ff,
                100 to 0xffe0e7ff,
                200 to 0xffc7d2fe,
                300 to 0xffa5b4fc,
                400 to 0xff818cf8,
                500 to 0xff6366f1,
                600 to 0xff4f46e5,
                700 to 0xff4338ca,
                800 to 0xff3730a3,
                900 to 0xff312e81
            ).asNamedPair(),
            ColorSwatch(
                SWATCH_NAME_VIOLET,
                50 to 0xfff5f3ff,
                100 to 0xffede9fe,
                200 to 0xffddd6fe,
                300 to 0xffc4b5fd,
                400 to 0xffa78bfa,
                500 to 0xff8b5cf6,
                600 to 0xff7c3aed,
                700 to 0xff6d28d9,
                800 to 0xff5b21b6,
                900 to 0xff4c1d95
            ).asNamedPair(),
            ColorSwatch(
                SWATCH_NAME_PURPLE,
                50 to 0xfffaf5ff,
                100 to 0xfff3e8ff,
                200 to 0xffe9d5ff,
                300 to 0xffd8b4fe,
                400 to 0xffc084fc,
                500 to 0xffa855f7,
                600 to 0xff9333ea,
                700 to 0xff7e22ce,
                800 to 0xff6b21a8,
                900 to 0xff581c87
            ).asNamedPair(),
            ColorSwatch(
                SWATCH_NAME_FUCHSIA,
                50 to 0xfffdf4ff,
                100 to 0xfffae8ff,
                200 to 0xfff5d0fe,
                300 to 0xfff0abfc,
                400 to 0xffe879f9,
                500 to 0xffd946ef,
                600 to 0xffc026d3,
                700 to 0xffa21caf,
                800 to 0xff86198f,
                900 to 0xff701a75
            ).asNamedPair(),
            ColorSwatch(
                SWATCH_NAME_PINK,
                50 to 0xfffdf2f8,
                100 to 0xfffce7f3,
                200 to 0xfffbcfe8,
                300 to 0xfff9a8d4,
                400 to 0xfff472b6,
                500 to 0xffec4899,
                600 to 0xffdb2777,
                700 to 0xffbe185d,
                800 to 0xff9d174d,
                900 to 0xff831843
            ).asNamedPair(),
            ColorSwatch(
                SWATCH_NAME_ROSE,
                50 to 0xfffff1f2,
                100 to 0xffffe4e6,
                200 to 0xfffecdd3,
                300 to 0xfffda4af,
                400 to 0xfffb7185,
                500 to 0xfff43f5e,
                600 to 0xffe11d48,
                700 to 0xffbe123c,
                800 to 0xff9f1239,
                900 to 0xff881337
            ).asNamedPair()
        )
}
