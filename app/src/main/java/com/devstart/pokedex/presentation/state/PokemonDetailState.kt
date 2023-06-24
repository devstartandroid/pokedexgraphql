package com.devstart.pokedex.presentation.state

import com.devstart.pokedex.presentation.dataui.PokemonDataUi

data class PokemonDetailState(
    val pokemon: PokemonDataUi? = null,
    val loading: Boolean = false,
    val error: Throwable? = null
)