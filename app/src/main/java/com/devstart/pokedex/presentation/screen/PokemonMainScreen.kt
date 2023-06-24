package com.devstart.pokedex.presentation.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.devstart.pokedex.presentation.dataui.TypeDataUi
import com.devstart.pokedex.presentation.state.AppBarState
import com.devstart.pokedex.presentation.state.PokemonDetailState
import com.devstart.pokedex.presentation.state.PokemonListState
import com.devstart.pokedex.ui.components.AppTopBar
import com.devstart.pokedex.ui.theme.PokeDexTheme

@Composable
fun PokemonMainScreen(
    pokemonListState: PokemonListState,
    pokemonDetailState: PokemonDetailState,
    onSearchValueChanged: (String) -> Unit,
    onPokemonDetailLoaded: (String) -> Unit
) {
    Column {
        var appBarState: AppBarState by remember {
            mutableStateOf(AppBarState(withSearchField = true))
        }
        val navController = rememberNavController()

        PokemonMainAppTopBar(
            appBarState = appBarState,
            navController = navController,
            onClickBack = {
                appBarState = AppBarState(withSearchField = true)
            },
            onSearchValueChanged = onSearchValueChanged
        )
        PokemonMainNavigation(
            navController = navController,
            pokemonListState = pokemonListState,
            pokemonDetailState = pokemonDetailState,
            appBarUpdate = { newAppBarState ->
                appBarState = newAppBarState
            },
            onPokemonDetailLoaded = onPokemonDetailLoaded
        )


    }
}

@Composable
fun PokemonMainAppTopBar(
    appBarState: AppBarState,
    navController: NavHostController,
    onClickBack: () -> Unit,
    onSearchValueChanged: (String) -> Unit
) {
    var searchValue: String by rememberSaveable { mutableStateOf("") }

    AppTopBar(
        withSearchField = appBarState.withSearchField,
        withBackIcon = appBarState.withBackButton,
        title = appBarState.title,
        onClickBack = {
            onClickBack()
            navController.navigateUp()
        },
        onSearchValueChanged = {
            onSearchValueChanged(it)
            searchValue = it
        },
        searchValue = searchValue
    )
}

@Composable
fun PokemonMainNavigation(
    navController: NavHostController,
    pokemonListState: PokemonListState,
    pokemonDetailState: PokemonDetailState,
    appBarUpdate: (AppBarState) -> Unit,
    onPokemonDetailLoaded: (String) -> Unit
) {
    NavHost(navController = navController, startDestination = "PokemonList") {
        composable("PokemonList") {
            appBarUpdate(AppBarState(withSearchField = true))
            PokemonListScreen(
                pokemonListState = pokemonListState,
                onPokemonClick = {
                    navController.navigate("PokemonDetail/${it.name}/${it.types[0].name}")
                    onPokemonDetailLoaded(it.name)
                }
            )
        }
        composable(
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
            val pokemonName: String? by remember {
                mutableStateOf(
                    it.arguments?.getString(
                        "pokemonName"
                    )
                )
            }

            val pokemonType: String? by remember {
                mutableStateOf(
                    it.arguments?.getString(
                        "pokemonType"
                    )
                )
            }

            pokemonName?.let {
                appBarUpdate(AppBarState(withBackButton = true, title = it))
                PokemonDetailScreen(
                    type = TypeDataUi.valueOf(pokemonType ?: "UNKNOWN"),
                    pokemonDetailState = pokemonDetailState,
                    onPokemonEvolutionClick = { pokemonName ->
                        onPokemonDetailLoaded(pokemonName)
                    }
                )
            }
        }

    }
}

@Composable
@Preview
fun PokemonMainScreenPreview() {
    PokeDexTheme {
        PokemonMainScreen(
            pokemonListState = previewPokemonListState,
            pokemonDetailState = previewPokemonDetailState,
            onSearchValueChanged = {},
            onPokemonDetailLoaded = {}
        )
    }
}