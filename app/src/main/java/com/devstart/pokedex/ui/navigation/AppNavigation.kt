package com.devstart.pokedex.ui.navigation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.devstart.pokedex.presentation.dataui.TypeDataUi
import com.devstart.pokedex.presentation.screen.PokemonDetailScreen
import com.devstart.pokedex.presentation.screen.PokemonListScreen
import com.devstart.pokedex.presentation.state.PokemonDetailState
import com.devstart.pokedex.presentation.state.PokemonListState

object AppNavigation {

    private var navGraphBuilder: NavGraphBuilder? = null

    fun setupNavGraph(
        navGraphBuilder: NavGraphBuilder
    ) {
        this.navGraphBuilder = navGraphBuilder
    }

    fun pokemonListDestination(
        navController: NavHostController,
        pokemonListState: PokemonListState,
        onPokemonDetailLoaded: (String) -> Unit,
        onNavigate: () -> Unit
    ) {
        navGraphBuilder?.composable("PokemonList") {
            PokemonListScreen(
                pokemonListState = pokemonListState,
                onPokemonClick = {
                    onPokemonDetailLoaded(it.name)
                    navigateToDetailPokemon(navController, it.name, it.types[0].name)
                }
            )
            onNavigate()
        }
    }

    fun pokemonDetailDestination(
        pokemonDetailState: PokemonDetailState,
        onPokemonDetailLoaded: (String) -> Unit,
        onNavigate: (pokemonName: String?) -> Unit
    ) {
        navGraphBuilder?.composable(
            "PokemonDetail/{pokemonName}/{pokemonType}",
            arguments = listOf(
                navArgument("pokemonName") {
                    type = NavType.StringType
                },
                navArgument("pokemonType") {
                    type = NavType.StringType
                }
            )
        ) {
            val pokemonNameState: String? by remember {
                mutableStateOf(
                    it.arguments?.getString(
                        "pokemonName"
                    )
                )
            }

            val pokemonTypeState: String? by remember {
                mutableStateOf(
                    it.arguments?.getString(
                        "pokemonType"
                    )
                )
            }

            pokemonNameState?.let {
                PokemonDetailScreen(
                    type = TypeDataUi.valueOf(pokemonTypeState ?: "UNKNOWN"),
                    pokemonDetailState = pokemonDetailState,
                    onPokemonEvolutionClick = { pokemonName ->
                        onPokemonDetailLoaded(pokemonName)
                    }
                )
            }
            onNavigate(pokemonNameState)
        }
    }

    private fun navigateToDetailPokemon(
        navController: NavHostController,
        pokemonName: String?,
        pokemonType: String
    ) {
        navController.navigate("PokemonDetail/${pokemonName}/${pokemonType}")
    }
}