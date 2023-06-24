package com.devstart.pokedex.ui.components

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.devstart.pokedex.ui.theme.HP_BAR_COLOR
import com.devstart.pokedex.ui.theme.PokeDexTheme
import com.devstart.pokedex.ui.theme.STROKE_BAR_COLOR
import com.devstart.pokedex.ui.theme.TRACK_BAR_COLOR
import com.devstart.pokedex.util.toSafeFloat

@Composable
fun AppLinearStatsIndicator(
    modifier: Modifier = Modifier,
    percentage: Float,
    barColor: Color
) {
    val progress by remember { mutableStateOf(Animatable(0F)) }
    LinearProgressIndicator(
        modifier = modifier
            .height(10.dp)
            .clip(RoundedCornerShape(10.dp))
            .border(BorderStroke(1.dp, STROKE_BAR_COLOR), RoundedCornerShape(10.dp)),
        progress = progress.value,
        color = barColor,
        trackColor = TRACK_BAR_COLOR
    )
    LaunchedEffect(Unit) {
        progress.animateTo(
            targetValue = percentage.toSafeFloat(),
            animationSpec = tween(1500)
        )
    }
}

@Composable
@Preview
fun AppLinearStatsIndicatorPreview() {
    PokeDexTheme {
        AppLinearStatsIndicator(
            percentage = 0.5f,
            barColor = HP_BAR_COLOR
        )
    }
}