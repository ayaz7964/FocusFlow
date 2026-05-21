package com.example.focusflow.ui.theme

//class Theme
//{
//}

//package com.focusflow.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val LightColorScheme = lightColorScheme(
    primary = DeepBlue,
    secondary = Purple,
    tertiary = Green,
    background = LightGray,
    surface = Surface,
    onPrimary = Color.White,
    onSecondary = Color.White,
    onBackground = TextPrimary,
    onSurface = TextPrimary
)

@Composable
fun FocusFlowTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colorScheme = if (!darkTheme) LightColorScheme else darkColorScheme(
        primary = DeepBlue,
        secondary = Purple
    )
    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography(),
        content = content
    )
}