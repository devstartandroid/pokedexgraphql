package com.devstart.pokedex.domain.usecase

import com.devstart.pokedex.domain.repository.PokemonsRepository

class GetPokemonsUseCase(
    private val repository: PokemonsRepository
) {
    suspend operator fun invoke() = repository.getPokemons()
}