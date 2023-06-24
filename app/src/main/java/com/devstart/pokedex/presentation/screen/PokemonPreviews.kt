package com.devstart.pokedex.presentation.screen

import com.devstart.pokedex.presentation.dataui.PokemonDataUi
import com.devstart.pokedex.presentation.dataui.StatsDataUi
import com.devstart.pokedex.presentation.dataui.TypeDataUi
import com.devstart.pokedex.presentation.state.AppBarState
import com.devstart.pokedex.presentation.state.PokemonDetailState
import com.devstart.pokedex.presentation.state.PokemonListState

val previewPokemonListState = PokemonListState(
    pokemons = listOf(
        PokemonDataUi(
            id = 1,
            name = "Bulbasaur",
            imageUrl = "",
            stats = StatsDataUi(
                hp = 100,
                attack = 100,
                defense = 100,
                speed = 100
            ),
            evolutionChain = null,
            types = listOf(
                TypeDataUi.GRASS,
                TypeDataUi.POISON
            )
        ),
        PokemonDataUi(
            id = 1,
            name = "Charmander",
            imageUrl = "",
            stats = StatsDataUi(
                hp = 100,
                attack = 100,
                defense = 100,
                speed = 100
            ),
            evolutionChain = null,
            types = listOf(
                TypeDataUi.FIRE
            )
        ),
        PokemonDataUi(
            id = 1,
            name = "Pikachu",
            imageUrl = "",
            stats = StatsDataUi(
                hp = 100,
                attack = 100,
                defense = 100,
                speed = 100
            ),
            evolutionChain = null,
            types = listOf(
                TypeDataUi.ELECTRIC
            )
        ),
        PokemonDataUi(
            id = 1,
            name = "Ratatta",
            imageUrl = "",
            stats = StatsDataUi(
                hp = 100,
                attack = 100,
                defense = 100,
                speed = 100
            ),
            evolutionChain = null,
            types = listOf(
                TypeDataUi.NORMAL
            )
        )
    )
)

val previewAppBarStateWithSearch = AppBarState(
    withSearchField = true
)

val previewPokemonDetailState = PokemonDetailState(
    pokemon = PokemonDataUi(
        id = 1,
        name = "Bulbasaur",
        imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/1.png",
        stats = StatsDataUi(
            hp = 100,
            attack = 75,
            defense = 50,
            speed = 25
        ),
        evolutionChain = listOf(
            PokemonDataUi(
                id = 1,
                name = "Bulbasaur",
                imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/1.png",
                stats = StatsDataUi(
                    hp = 100,
                    attack = 75,
                    defense = 50,
                    speed = 25
                ),
                evolutionChain = null,
                types = listOf(
                    TypeDataUi.GRASS,
                    TypeDataUi.POISON
                )
            ),
            PokemonDataUi(
                id = 1,
                name = "Bulbasaur",
                imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/1.png",
                stats = StatsDataUi(
                    hp = 100,
                    attack = 75,
                    defense = 50,
                    speed = 25
                ),
                evolutionChain = null,
                types = listOf(
                    TypeDataUi.GRASS,
                    TypeDataUi.POISON
                )
            )
        ),
        types = listOf(
            TypeDataUi.GRASS,
            TypeDataUi.POISON
        )
    )
)