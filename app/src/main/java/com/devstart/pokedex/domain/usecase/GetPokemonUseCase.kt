package com.devstart.pokedex.domain.usecase

import com.devstart.pokedex.domain.repository.PokemonsRepository

class GetPokemonUseCase(
    private val repository: PokemonsRepository
) {
    suspend operator fun invoke(name: String) = repository.getPokemon(name)
}