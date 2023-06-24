package com.devstart.pokedex.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalInspectionMode
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.devstart.pokedex.R
import com.devstart.pokedex.ui.theme.PokeDexTheme

@Composable
fun AppPokemonWithShadowImage(
    imageUrl: String
) {
    val isPreview = LocalInspectionMode.current
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        AsyncImage(
            modifier = Modifier.size(116.dp),
            model = imageUrl,
            contentScale = ContentScale.Crop,
            contentDescription = null,
            placeholder = if (isPreview) painterResource(id = R.drawable.preview_pokemon) else null
        )
        Image(
            modifier = Modifier.offset(y = (-4).dp),
            painter = painterResource(id = R.drawable.pokemon_shadow),
            contentDescription = null
        )
    }

}

@Composable
@Preview
fun AppPokemonWithShadowImagePreview() {
    PokeDexTheme {
        AppPokemonWithShadowImage(
            imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/1.png"
        )
    }
}