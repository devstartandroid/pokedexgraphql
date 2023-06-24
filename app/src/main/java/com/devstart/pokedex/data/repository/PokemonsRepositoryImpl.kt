package com.devstart.pokedex.data.repository

import androidx.compose.ui.text.intl.Locale
import androidx.compose.ui.text.toLowerCase
import com.devstart.pokedex.data.datasource.PokemonRemoteDataSource
import com.devstart.pokedex.data.mapper.PokemonModelMapper
import com.devstart.pokedex.data.mapper.PokemonsModelMapper
import com.devstart.pokedex.domain.model.Pokemon
import com.devstart.pokedex.domain.repository.PokemonsRepository

class PokemonsRepositoryImpl(
    private val remoteDataSource: PokemonRemoteDataSource,
    private val pokemonsModelMapper: PokemonsModelMapper,
    private val pokemonModelMapper: PokemonModelMapper
): PokemonsRepository {
    override suspend fun getPokemons(): List<Pokemon> {
        remoteDataSource.getPokemons().data?.getPokemonsResponse?.let {
            return pokemonsModelMapper.toDomainList(it)
        } ?: throw RuntimeException("Get Pokemons Error")
    }

    override suspend fun getPokemon(name: String): Pokemon {
        remoteDataSource.getPokemon(name.toLowerCase(Locale.current)).data?.getPokemonResponse?.let {
            return pokemonModelMapper.toDomain(it[0])
        } ?: throw RuntimeException("Get Pokemon Error")
    }
}