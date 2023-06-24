package com.devstart.pokedex.domain.usecase

import com.devstart.pokedex.domain.repository.PokemonsRepository
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.Test

class GetPokemonUseCaseTest {
    private val repository: PokemonsRepository = mockk()

    private val subjectUseCase = GetPokemonUseCase(repository)

    @Test
    fun `when get pokemon repository should called`() = runBlocking {
        // Given
        coEvery { repository.getPokemon(any()) } returns mockedPokemon

        // When
        subjectUseCase("Bulbasaur")

        // Then
        coVerify { repository.getPokemon("Bulbasaur") }
    }
}