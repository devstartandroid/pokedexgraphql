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
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.devstart.pokedex.presentation.state.AppBarState
import com.devstart.pokedex.presentation.state.PokemonDetailState
import com.devstart.pokedex.presentation.state.PokemonListState
import com.devstart.pokedex.ui.components.AppTopBar
import com.devstart.pokedex.ui.navigation.AppNavigation
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

        AppNavigation.setupNavGraph(this)

        AppNavigation.pokemonListDestination(
            navController,
            pokemonListState,
            onPokemonDetailLoaded
        ) {
            appBarUpdate(AppBarState(withSearchField = true))
        }

        AppNavigation.pokemonDetailDestination(
            pokemonDetailState,
            onPokemonDetailLoaded
        ) {
            appBarUpdate(AppBarState(withBackButton = true, title = it))
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