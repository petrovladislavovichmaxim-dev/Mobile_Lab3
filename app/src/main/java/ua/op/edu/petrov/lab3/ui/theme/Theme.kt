package ua.op.edu.petrov.lab3.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val NeutralScheme = lightColorScheme(
    primary = Color(0xFF2D2D2D),
    onPrimary = Color.White,
    secondary = Color(0xFF5A5A5A),
    onSecondary = Color.White,
    surface = Color(0xFFF7F7F7),
    onSurface = Color(0xFF1A1A1A),
    background = Color(0xFFFFFFFF),
    onBackground = Color(0xFF1A1A1A),
)

@Composable
fun PetrovLab3Theme(content: @Composable () -> Unit) {
    MaterialTheme(
        colorScheme = NeutralScheme,
        content = content,
    )
}
