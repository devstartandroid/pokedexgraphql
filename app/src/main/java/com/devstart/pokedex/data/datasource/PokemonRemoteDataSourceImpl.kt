package com.devstart.pokedex.data.datasource

import com.apollographql.apollo3.api.ApolloResponse
import com.devstart.pokedex.GetPokemonQuery
import com.devstart.pokedex.GetPokemonsQuery
import com.devstart.pokedex.data.service.getApolloClient

class PokemonRemoteDataSourceImpl : PokemonRemoteDataSource {
    override suspend fun getPokemons(): ApolloResponse<GetPokemonsQuery.Data> {
        return getApolloClient().query(GetPokemonsQuery()).execute()
    }

    override suspend fun getPokemon(name: String): ApolloResponse<GetPokemonQuery.Data> {
        return getApolloClient().query(GetPokemonQuery(name)).execute()
    }
}