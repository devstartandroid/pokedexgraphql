package com.devstart.pokedex.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.PlatformTextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.devstart.pokedex.R
import com.devstart.pokedex.ui.theme.HP_BAR_COLOR
import com.devstart.pokedex.ui.theme.PokeDexTheme

@Composable
fun AppStatsCard(
    modifier: Modifier = Modifier,
    stat: String,
    statPercentage: Float,
    barColor: Color,
    statValue: String,
) {
    Column(
        modifier = modifier
    ) {
        Text(
            text = stat,
            fontFamily = FontFamily(Font(R.font.roboto_bold_font))
        )
        Row(
            modifier = Modifier.padding(top = 4.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            AppLinearStatsIndicator(
                modifier = Modifier
                    .weight(1f),
                percentage = statPercentage,
                barColor = barColor
            )
            Text(
                modifier = Modifier.padding(start = 8.dp),
                text = statValue,
                style = MaterialTheme.typography.titleMedium.copy(
                    platformStyle = PlatformTextStyle(
                        includeFontPadding = false,
                    )
                ),
                fontFamily = FontFamily(Font(R.font.roboto_bold_font))
            )
        }
    }
}

@Composable
@Preview
fun AppStatsCardPreview() {
    PokeDexTheme {
        AppStatsCard(
            stat = "Hp",
            statPercentage = 1f,
            barColor = HP_BAR_COLOR,
            statValue = "100"
        )
    }
}