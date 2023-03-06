package com.devstart.pokedex.domain.repository

import com.devstart.pokedex.domain.model.Pokemon

interface PokemonsRepository {
    suspend fun getPokemons() : List<Pokemon>

    suspend fun getPokemon(name: String): Pokemon
}