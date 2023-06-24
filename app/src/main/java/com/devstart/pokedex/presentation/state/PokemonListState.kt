package com.devstart.pokedex.presentation.state

import com.devstart.pokedex.presentation.dataui.PokemonDataUi

data class PokemonListState(
    val pokemons: List<PokemonDataUi>? = null,
    val loading: Boolean = false,
    val error: Throwable? = null
)