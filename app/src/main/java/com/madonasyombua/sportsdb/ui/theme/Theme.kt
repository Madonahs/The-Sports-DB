package com.madonasyombua.sportsdb.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

 val LightColors = lightColors(
    primary = Green700,
    primaryVariant = Green900,
    onPrimary = Color.White,
    secondary = Green700,
    secondaryVariant = Green900,
    onSecondary = Color.White,
    error = Green800,
)

private val DarkColors = darkColors(
    primary = Green300,
    primaryVariant = Green700,
    onPrimary = Color.Black,
    secondary = Green300,
    onSecondary = Color.Black,
    error = Green200,
)


@Composable
fun SportsAppTheme(darkTheme: Boolean, content:@Composable ()->Unit){
    MaterialTheme(
        content = content,
        colors = if (darkTheme) DarkColors else LightColors,
        typography = SportsAppTypography)
}

