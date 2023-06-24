package com.devstart.pokedex.presentation

import com.devstart.pokedex.domain.model.Pokemon
import com.devstart.pokedex.domain.model.Stats
import com.devstart.pokedex.domain.model.Type
import com.devstart.pokedex.presentation.dataui.PokemonDataUi
import com.devstart.pokedex.presentation.dataui.StatsDataUi
import com.devstart.pokedex.presentation.dataui.TypeDataUi

val mockedBulbasaur = Pokemon(
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
            type = listOf(Type.GRASS),
            imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/2.png",
            stats = Stats(
                hp = 53,
                attack = 65,
                defense = 27,
                speed = 40
            ),
            evolutionChain = null
        ),
        Pokemon(
            id = 3,
            name = "Venusaur",
            type = listOf(Type.GRASS),
            imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/3.png",
            stats = Stats(
                hp = 53,
                attack = 65,
                defense = 27,
                speed = 40
            ),
            evolutionChain = null
        )
    )
)

val mockedPikachu = Pokemon(
    id = 10,
    name = "Pikachu",
    type = listOf(Type.ELECTRIC),
    imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/10.png",
    stats = Stats(
        hp = 53,
        attack = 65,
        defense = 27,
        speed = 40
    ),
    evolutionChain = null
)

val mockedBulbasaurDataUI = PokemonDataUi(
    id = 1,
    name = "Bulbasaur",
    types = listOf(TypeDataUi.GRASS),
    imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/1.png",
    stats = StatsDataUi(
        hp = 53,
        attack = 65,
        defense = 27,
        speed = 40
    ),
    evolutionChain = listOf(
        PokemonDataUi(
            id = 2,
            name = "Ivysaur",
            types = listOf(TypeDataUi.GRASS),
            imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/2.png",
            stats = StatsDataUi(
                hp = 53,
                attack = 65,
                defense = 27,
                speed = 40
            ),
            evolutionChain = null
        ),
        PokemonDataUi(
            id = 3,
            name = "Venusaur",
            types = listOf(TypeDataUi.GRASS),
            imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/3.png",
            stats = StatsDataUi(
                hp = 53,
                attack = 65,
                defense = 27,
                speed = 40
            ),
            evolutionChain = null
        )
    )
)

val mockedPikachuDataUI = PokemonDataUi(
    id = 10,
    name = "Pikachu",
    types = listOf(TypeDataUi.ELECTRIC),
    imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/10.png",
    stats = StatsDataUi(
        hp = 53,
        attack = 65,
        defense = 27,
        speed = 40
    ),
    evolutionChain = null
)