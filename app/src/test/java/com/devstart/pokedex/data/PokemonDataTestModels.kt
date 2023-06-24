package com.devstart.pokedex.data.repository

import com.apollographql.apollo3.api.ApolloResponse
import com.devstart.pokedex.GetPokemonQuery
import com.devstart.pokedex.GetPokemonsQuery
import com.devstart.pokedex.domain.model.Pokemon
import io.mockk.mockk

//Response
val pokemonResponse1 = GetPokemonsQuery.GetPokemonsResponse(
    name = "bulbasaur",
    id = 1,
    pokemon = emptyList(),
)

val pokemonResponse2 = GetPokemonsQuery.GetPokemonsResponse(
    name = "charmander",
    id = 2,
    pokemon = emptyList(),
)

val pokemonResponse3 = GetPokemonsQuery.GetPokemonsResponse(
    name = "pikachu",
    id = 3,
    pokemon = emptyList(),
)

val pokemonsResponse = ApolloResponse.Builder(
    operation = mockk(),
    requestUuid = mockk(),
    data = GetPokemonsQuery.Data(listOf(pokemonResponse1, pokemonResponse2, pokemonResponse3))
).build()

val getPokemonApolloResponse = ApolloResponse.Builder(
    operation = mockk(), requestUuid = mockk(), data = GetPokemonQuery.Data(
        listOf(
            GetPokemonQuery.GetPokemonResponse(
                listOf(
                    GetPokemonQuery.Pokemon(
                        id = 1,
                        name = "bulbasaur",
                        types = emptyList(),
                        stats = emptyList(),
                        specy = null
                    )
                )
            )
        )
    )
).build()

val getPokemonsNullDataApolloResponse =
    ApolloResponse.Builder<GetPokemonsQuery.Data>(
        operation = mockk(), requestUuid = mockk(), data = null
    ).build()

val getPokemonNullDataApolloResponse =
    ApolloResponse.Builder<GetPokemonQuery.Data>(
        operation = mockk(), requestUuid = mockk(), data = null
    ).build()

//Domain

val pokemon1 = Pokemon(
    id = 1,
    name = "bulbasaur",
    type = emptyList(),
    imageUrl = "imageUrl",
    stats = null,
    evolutionChain = null
)

val pokemon2 = Pokemon(
    id = 2,
    name = "charmander",
    type = emptyList(),
    imageUrl = "imageUrl",
    stats = null,
    evolutionChain = null
)

val pokemon3 = Pokemon(
    id = 3,
    name = "pikachu",
    type = emptyList(),
    imageUrl = "imageUrl",
    stats = null,
    evolutionChain = null
)

val pokemonList = listOf(pokemon1, pokemon2, pokemon3)

val hpResponseStat = GetPokemonQuery.Stat(
    value = 53,
    stat = GetPokemonQuery.Stat1(
        name = "hp"
    )
)

val attackResponseStat = GetPokemonQuery.Stat(
    value = 65,
    stat = GetPokemonQuery.Stat1(
        name = "attack"
    )
)

val defenseResponseStat = GetPokemonQuery.Stat(
    value = 27,
    stat = GetPokemonQuery.Stat1(
        name = "defense"
    )
)

val speedResponseStat = GetPokemonQuery.Stat(
    value = 40,
    stat = GetPokemonQuery.Stat1(
        name = "speed"
    )
)

val statsResponse = listOf(
    hpResponseStat, attackResponseStat, defenseResponseStat, speedResponseStat
)

val pokemonIvysaurSpeciesResponse = GetPokemonQuery.Species(
    pokemons = listOf(
        GetPokemonQuery.Pokemon1(
            id = 2, name = "Ivysaur", pokemonSprites = emptyList()
        )
    )
)

val pokemonVenusaurSpeciesResponse = GetPokemonQuery.Species(
    pokemons = listOf(
        GetPokemonQuery.Pokemon1(
            id = 3, name = "Venusaur", pokemonSprites = emptyList()
        )
    )
)

val getPokemonResponse = GetPokemonQuery.GetPokemonResponse(
    pokemons = listOf(
        GetPokemonQuery.Pokemon(
            id = 1,
            name = "Bulbasaur",
            types = listOf(
                GetPokemonQuery.Type(
                    type = GetPokemonQuery.Type1(
                        name = "grass"
                    )
                )
            ),
            stats = listOf(
                hpResponseStat,
                defenseResponseStat,
                speedResponseStat,
                attackResponseStat
            ),
            specy = GetPokemonQuery.Specy(
                evolutionChain = GetPokemonQuery.EvolutionChain(
                    species = listOf(pokemonIvysaurSpeciesResponse, pokemonVenusaurSpeciesResponse)
                )
            )
        )
    )
)

val getPokemonsResponse = GetPokemonsQuery.GetPokemonsResponse(
    name = "Bulbasaur",
    id = 1,
    pokemon = listOf(
        GetPokemonsQuery.Pokemon(
            types = listOf(
                GetPokemonsQuery.Type(
                    type = GetPokemonsQuery.Type1(
                        name = "grass"
                    )
                )
            ),
            pokemonSprites = emptyList()
        )
    )
)