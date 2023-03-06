package com.devstart.pokedex.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.devstart.pokedex.presentation.dataui.TypeDataUi
import com.devstart.pokedex.ui.theme.PokeDexTheme

@Composable
fun AppPokemonCard(
    modifier: Modifier = Modifier,
    pokemonName: String,
    imageUrl: String,
    types: List<TypeDataUi>
) {

    val backgroundColor = types[0].backgroundColor
    AppGradientBackgroundPokemonCard(
        modifier = modifier,
        backgroundColor = backgroundColor
    ) {
        Column(
            modifier = Modifier.padding(12.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            AppPokemonWithShadowImage(imageUrl = imageUrl)
            AppPokemonCardNameType(pokemonName = pokemonName, types = types)
        }
    }
}

@Composable
@Preview(showBackground = true, backgroundColor = 0xFFFFFFFF)
fun AppPokemonCardPreview() {
    PokeDexTheme {
        AppPokemonCard(
            pokemonName = "Bulbasaur",
            imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/1.png",
            types = listOf(
                TypeDataUi.FIRE,
                TypeDataUi.ELECTRIC
            )
        )
    }
}
