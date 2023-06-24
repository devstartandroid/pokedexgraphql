package com.devstart.pokedex.domain.usecase

import com.devstart.pokedex.domain.model.Pokemon
import com.devstart.pokedex.domain.model.Stats
import com.devstart.pokedex.domain.model.Type

val mockedPokemon = Pokemon(
    id = 1,
    name = "Bulbasaur",
    type = listOf(Type.GRASS),
    imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/1.png",
    stats = Stats(
        hp = 53,
        attack = 65,
        defense = 27,
        speed = 40
    ),
    evolutionChain = listOf(
        Pokemon(
            id = 2,
            name = "Ivysaur",
            type = emptyList(),
            imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/2.png",
            stats = null,
            evolutionChain = null
        ),
        Pokemon(
            id = 3,
            name = "Venusaur",
            type = emptyList(),
            imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/3.png",
            stats = null,
            evolutionChain = null
        )
    )
)

val mockedPokemonList = listOf(
    Pokemon(
        id = 1,
        name = "Bulbasaur",
        type = listOf(Type.GRASS),
        imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/1.png",
        stats = Stats(
            hp = 53,
            attack = 65,
            defense = 27,
            speed = 40
        ),
        evolutionChain = listOf(
            Pokemon(
                id = 2,
                name = "Ivysaur",
                type = emptyList(),
                imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/2.png",
                stats = null,
                evolutionChain = null
            ),
            Pokemon(
                id = 3,
                name = "Venusaur",
                type = emptyList(),
                imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/3.png",
                stats = null,
                evolutionChain = null
            )
        )
    )
)