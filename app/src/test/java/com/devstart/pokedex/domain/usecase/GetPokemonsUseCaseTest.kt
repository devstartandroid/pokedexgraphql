package com.devstart.pokedex.domain.usecase

import com.devstart.pokedex.domain.repository.PokemonsRepository
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.Test

class GetPokemonsUseCaseTest {
    private val repository: PokemonsRepository = mockk()

    private val subjectUseCase = GetPokemonsUseCase(repository)

    @Test
    fun `when get pokemon repository should called`() = runBlocking {
        // Given
        coEvery { repository.getPokemons() } returns mockedPokemonList

        // When
        subjectUseCase()

        // Then
        coVerify { repository.getPokemons() }
    }
}