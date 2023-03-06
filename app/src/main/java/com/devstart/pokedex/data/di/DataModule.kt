package com.devstart.pokedex.data.di

import com.devstart.pokedex.data.datasource.PokemonRemoteDataSource
import com.devstart.pokedex.data.datasource.PokemonRemoteDataSourceImpl
import com.devstart.pokedex.data.mapper.PokemonEvolutionChainModelMapper
import com.devstart.pokedex.data.mapper.PokemonModelMapper
import com.devstart.pokedex.data.mapper.PokemonStatsModelMapper
import com.devstart.pokedex.data.mapper.PokemonsModelMapper
import com.devstart.pokedex.data.repository.PokemonsRepositoryImpl
import com.devstart.pokedex.domain.repository.PokemonsRepository
import org.koin.dsl.module

val dataModule = module {
    factory<PokemonRemoteDataSource> { PokemonRemoteDataSourceImpl() }
    factory { PokemonsModelMapper() }
    factory { PokemonModelMapper(
        PokemonEvolutionChainModelMapper(),
        PokemonStatsModelMapper()
    ) }
    factory<PokemonsRepository> {
        PokemonsRepositoryImpl(
            remoteDataSource = get(),
            pokemonsModelMapper = get(),
            pokemonModelMapper = get()
        )
    }
}