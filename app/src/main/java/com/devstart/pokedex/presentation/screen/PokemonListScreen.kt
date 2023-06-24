package com.devstart.pokedex.presentation.screen

import android.annotation.SuppressLint
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.fadeIn
import androidx.compose.animation.scaleIn
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.devstart.pokedex.presentation.dataui.PokemonDataUi
import com.devstart.pokedex.presentation.state.PokemonListState
import com.devstart.pokedex.ui.components.AppLoadingPokeBall
import com.devstart.pokedex.ui.components.AppPokemonCard
import com.devstart.pokedex.ui.theme.PokeDexTheme

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class, ExperimentalAnimationApi::class)
@Composable
fun PokemonListScreen(
    pokemonListState: PokemonListState,
    onPokemonClick: (PokemonDataUi) -> Unit
) {
    Scaffold {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            if (pokemonListState.loading) {
                AppLoadingPokeBall(modifier = Modifier.size(64.dp))
            }
            val fadeIn = fadeIn(initialAlpha = 0F)
            val scaleIn = scaleIn(initialScale = 0F)

            androidx.compose.animation.AnimatedVisibility(
                visible = pokemonListState.error == null && pokemonListState.loading.not(),
                enter = fadeIn + scaleIn
            ) {
                LazyVerticalGrid(
                    modifier = Modifier.fillMaxHeight(),
                    columns = GridCells.Fixed(2),
                    contentPadding = PaddingValues(16.dp),
                    verticalArrangement = Arrangement.spacedBy(8.dp),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    pokemonListState.pokemons?.let { pokemons ->
                        items(pokemons) { pokemon ->
                            AppPokemonCard(
                                modifier = Modifier.clickable {
                                    onPokemonClick(pokemon)
                                },
                                pokemonName = pokemon.name,
                                imageUrl = pokemon.imageUrl,
                                types = pokemon.types,
                            )
                        }
                    }
                }
            }
        }
    }
}

@Composable
@Preview
fun PokemonListScreenPreview() {
    PokeDexTheme {
        PokemonListScreen(
            pokemonListState = previewPokemonListState,
            onPokemonClick = {}
        )
    }
}