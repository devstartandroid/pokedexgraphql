package com.devstart.pokedex.presentation.di

import com.devstart.pokedex.presentation.mapper.PokemonDataUiMapper
import com.devstart.pokedex.presentation.mapper.StatsDataUiMapper
import com.devstart.pokedex.presentation.mapper.TypeDataUiMapper
import com.devstart.pokedex.presentation.viewmodel.PokedexViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val presentationModule = module {
    factory { PokemonDataUiMapper(StatsDataUiMapper(), TypeDataUiMapper()) }
    viewModel { PokedexViewModel(getPokemonsUseCase = get(), getPokemonUseCase = get(), pokemonDataUiMapper = get()) }
}