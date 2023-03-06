package com.devstart.pokedex.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ShapeDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.dp

@Composable
fun AppGradientBackgroundPokemonCard(
    modifier: Modifier = Modifier,
    backgroundColor: Color,
    cardShape: Shape = RoundedCornerShape(16.dp),
    content: @Composable () -> Unit
) {
    Box(
        modifier = modifier
            .clip(cardShape)
            .background(
                Brush.verticalGradient(
                    colors = listOf(backgroundColor.copy(alpha = 0.05f), backgroundColor)
                )
            )
    ){
        content()
    }
}