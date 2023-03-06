package com.devstart.pokedex.domain.di

import com.devstart.pokedex.domain.usecase.GetPokemonUseCase
import com.devstart.pokedex.domain.usecase.GetPokemonsUseCase
import org.koin.dsl.module

val domainModule = module {
    factory { GetPokemonsUseCase(repository = get()) }
    factory { GetPokemonUseCase(repository = get()) }
}