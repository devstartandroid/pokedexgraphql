package com.devstart.pokedex.data.datasource

import com.apollographql.apollo3.api.ApolloResponse
import com.devstart.pokedex.GetPokemonQuery
import com.devstart.pokedex.GetPokemonsQuery


interface PokemonRemoteDataSource {
    suspend fun getPokemons(): ApolloResponse<GetPokemonsQuery.Data>

    suspend fun getPokemon(name: String): ApolloResponse<GetPokemonQuery.Data>
}