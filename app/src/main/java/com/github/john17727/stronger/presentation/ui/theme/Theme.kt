package com.github.john17727.stronger.presentation.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable

private val DarkColorPalette = darkColors(
    primary = StrongerBlueLight,
    secondary = StrongerBlueLight,
    background = StrongerBlack,
    surface = StrongerDark,
    onPrimary = StrongerWhite,
    onSecondary = StrongerWhite
)

private val LightColorPalette = lightColors(
    primary = StrongerBlue,
    secondary = StrongerBlue,
    background = StrongerWhite,
    surface = StrongerGrey,
    onPrimary = StrongerWhite,
    onSecondary = StrongerWhite,
    onSurface = StrongerTextGrey

    /* Other default colors to override
    background = Color.White,
    surface = Color.White,
    onPrimary = Color.White,
    onSecondary = Color.Black,
    onBackground = Color.Black,
    onSurface = Color.Black,
    */
)

@Composable
fun StrongerTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable() () -> Unit) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}