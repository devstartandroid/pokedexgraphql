package com.devstart.pokedex.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.devstart.pokedex.R
import com.devstart.pokedex.ui.theme.PokeDexTheme
import com.devstart.pokedex.ui.theme.TOPBAR_COLOR

@Composable
fun AppTopBar(
    modifier: Modifier = Modifier,
    withBackIcon: Boolean = false,
    withSearchField: Boolean = false,
    title: String? = null,
    onSearchValueChanged: (String) -> Unit = {},
    onClickBack: () -> Unit = {},
    searchValue: String = ""
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .background(color = TOPBAR_COLOR)
            .height(60.dp),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            contentAlignment = Alignment.CenterStart
        ) {
            if (title.isNullOrEmpty().not() && withSearchField.not()) {
                Text(
                    modifier = Modifier
                        .fillMaxWidth(),
                    text = title ?: "",
                    textAlign = TextAlign.Center,
                    style = MaterialTheme.typography.titleMedium.copy(
                        platformStyle = PlatformTextStyle(
                            includeFontPadding = false,
                        )
                    ),
                    fontSize = 20.sp,
                    fontFamily = FontFamily(Font(R.font.roboto_bold_font)),
                    color = Color.White
                )
            }

            if (withBackIcon) AppBackIconButton(
                onClick = onClickBack,
                color = Color.White
            )
        }
        if (withSearchField) {
            AppSearchBar(
                modifier = Modifier.padding(horizontal = 8.dp),
                label = "Search",
                onValueChange = onSearchValueChanged,
                searchValue = searchValue
            )
        }
    }
}

@Composable
@Preview
fun AppTopBarWithSearchPreview() {
    PokeDexTheme {
        AppTopBar(
            withBackIcon = false,
            withSearchField = true,
            onSearchValueChanged = {}
        )
    }
}

@Composable
@Preview
fun AppTopBarWithTitlePreview() {
    PokeDexTheme {
        AppTopBar(
            withBackIcon = true,
            withSearchField = false,
            title = "Bulbasaur",
            onSearchValueChanged = {},
            onClickBack = {}
        )
    }
}