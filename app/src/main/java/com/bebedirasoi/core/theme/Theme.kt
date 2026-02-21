package com.bebedirasoi.core.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val LightColors = lightColorScheme(
    primary = Color(0xFFF4A261),
    onPrimary = Color.White,
    background = Color(0xFFFFF8E7),
    surface = Color(0xFFFFF8E7),
    secondary = Color(0xFF8D6E63)
)

private val DarkColors = darkColorScheme(
    primary = Color(0xFFF4A261),
    secondary = Color(0xFF8D6E63)
)

@Composable
fun BebeDiRasoiTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colorScheme = LightColors,
        typography = Typography,
        content = content
    )
}
