package com.devstart.pokedex

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.devstart.pokedex.presentation.screen.PokemonMainScreen
import com.devstart.pokedex.presentation.state.AppBarState
import com.devstart.pokedex.presentation.viewmodel.PokedexViewModel
import com.devstart.pokedex.ui.theme.PokeDexTheme
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : ComponentActivity() {
    private val viewModel: PokedexViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PokeDexTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    PokemonMainScreen(
                        pokemonListState = viewModel.pokemonListState,
                        pokemonDetailState = viewModel.pokemonDetailState,
                        onSearchValueChanged = {
                            viewModel.onSearchValueChanged(it)
                        },
                        onPokemonDetailLoaded = { pokemonName ->
                            viewModel.getPokemonDetail(pokemonName)
                        }
                    )
                }

            }
        }
    }
}