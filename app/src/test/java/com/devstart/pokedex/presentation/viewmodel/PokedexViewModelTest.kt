package com.devstart.pokedex.presentation.viewmodel

import com.devstart.pokedex.domain.usecase.GetPokemonUseCase
import com.devstart.pokedex.domain.usecase.GetPokemonsUseCase
import com.devstart.pokedex.presentation.mapper.PokemonDataUiMapper
import com.devstart.pokedex.presentation.mockedBulbasaur
import com.devstart.pokedex.presentation.mockedBulbasaurDataUI
import com.devstart.pokedex.presentation.mockedPikachu
import com.devstart.pokedex.presentation.mockedPikachuDataUI
import com.google.common.truth.Truth
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import org.junit.Test

class PokedexViewModelTest {
    private val getPokemonsUseCase: GetPokemonsUseCase = mockk()
    private val getPokemonUseCase: GetPokemonUseCase = mockk()
    private val pokemonDataUiMapper: PokemonDataUiMapper = mockk()

    private fun createViewModel(): PokedexViewModel =
        PokedexViewModel(getPokemonsUseCase, getPokemonUseCase, pokemonDataUiMapper)

    @Test
    fun `when view model is instantiated and get pokemons sucess state SHOULD be updated`() =
        runBlocking {
            // Given
            coEvery { getPokemonsUseCase() } returns listOf(mockedBulbasaur)
            coEvery { pokemonDataUiMapper.toItemList(any()) } returns listOf(mockedBulbasaurDataUI)

            // When
            val viewModel = createViewModel()
            delay(300)

            // Then
            coVerify(exactly = 1) { getPokemonsUseCase() }
            Truth.assertThat(viewModel.pokemonListState.pokemons).isEqualTo(listOf(mockedBulbasaurDataUI))
            Truth.assertThat(viewModel.pokemonListState.loading).isFalse()
            Truth.assertThat(viewModel.pokemonListState.error).isNull()
        }

    @Test
    fun `when view model is instantiated and get pokemons throws exception state SHOULD be updated`() =
        runBlocking {
            // Given
            coEvery { getPokemonsUseCase() } throws RuntimeException("UnitTest")
            coEvery { pokemonDataUiMapper.toItemList(any()) } returns listOf(mockedBulbasaurDataUI)

            // When
            val viewModel = createViewModel()
            delay(300)

            // Then
            coVerify(exactly = 1) { getPokemonsUseCase() }
            Truth.assertThat(viewModel.pokemonListState.pokemons).isNull()
            Truth.assertThat(viewModel.pokemonListState.loading).isFalse()
            Truth.assertThat(viewModel.pokemonListState.error)
                .isInstanceOf(RuntimeException::class.java)
        }

    @Test
    fun `when get pokemon detail is called  get pokemon sucess state SHOULD be updated`() =
        runBlocking {
            // Given
            coEvery { getPokemonUseCase(any()) } returns mockedBulbasaur
            coEvery { pokemonDataUiMapper.toItem(any()) } returns mockedBulbasaurDataUI

            // When
            val viewModel = createViewModel()
            viewModel.getPokemonDetail("Bulbasaur")
            delay(300)

            // Then
            coVerify(exactly = 1) { getPokemonUseCase("Bulbasaur") }
            Truth.assertThat(viewModel.pokemonDetailState.pokemon).isEqualTo(mockedBulbasaurDataUI)
            Truth.assertThat(viewModel.pokemonDetailState.loading).isFalse()
            Truth.assertThat(viewModel.pokemonDetailState.error).isNull()
        }

    @Test
    fun `when get pokemon detail is called  get pokemon throw exception state SHOULD be updated`() =
        runBlocking {
            // Given
            coEvery { getPokemonUseCase(any()) } throws RuntimeException("UnitTest")
            coEvery { pokemonDataUiMapper.toItem(any()) } returns mockedBulbasaurDataUI

            // When
            val viewModel = createViewModel()
            viewModel.getPokemonDetail("Bulbasaur")
            delay(300)

            // Then
            coVerify(exactly = 1) { getPokemonUseCase("Bulbasaur") }
            Truth.assertThat(viewModel.pokemonDetailState.pokemon).isNull()
            Truth.assertThat(viewModel.pokemonDetailState.loading).isFalse()
            Truth.assertThat(viewModel.pokemonDetailState.error).isInstanceOf(RuntimeException::class.java)
        }

    @Test
    fun `when onSearchValueChanged with not empty query is called SHOULD update state with filtered list`() {

        runBlocking {
            // Given
            val expected = listOf(mockedPikachuDataUI)

            coEvery { getPokemonsUseCase() } returns listOf(mockedBulbasaur, mockedPikachu)
            coEvery { pokemonDataUiMapper.toItemList(any()) } returns listOf(mockedBulbasaurDataUI, mockedPikachuDataUI)

            // When
            val viewModel = createViewModel()
            delay(300)
            viewModel.onSearchValueChanged("Pikachu")
            delay(300)

            // Then
            Truth.assertThat(viewModel.pokemonListState.pokemons).isEqualTo(expected)
            Truth.assertThat(viewModel.pokemonListState.loading).isFalse()
            Truth.assertThat(viewModel.pokemonListState.error).isNull()
        }
    }

    @Test
    fun `when onSearchValueChanged with unknown pokemon query is called SHOULD update state to emptylist`() {

        runBlocking {
            // Given
            coEvery { getPokemonsUseCase() } returns listOf(mockedBulbasaur, mockedPikachu)
            coEvery { pokemonDataUiMapper.toItemList(any()) } returns listOf(mockedBulbasaurDataUI, mockedPikachuDataUI)

            // When
            val viewModel = createViewModel()
            delay(300)
            viewModel.onSearchValueChanged("Unknown")
            delay(300)

            // Then
            Truth.assertThat(viewModel.pokemonListState.pokemons).isEmpty()
            Truth.assertThat(viewModel.pokemonListState.loading).isFalse()
            Truth.assertThat(viewModel.pokemonListState.error).isNull()
        }
    }

    @Test
    fun `when onSearchValueChanged with empty query is called SHOULD update state with default list`() {

        runBlocking {
            // Given
            val pokemonListUI = listOf(mockedBulbasaurDataUI, mockedPikachuDataUI)

            coEvery { getPokemonsUseCase() } returns listOf(mockedBulbasaur, mockedPikachu)
            coEvery { pokemonDataUiMapper.toItemList(any()) } returns pokemonListUI

            // When
            val viewModel = createViewModel()
            delay(300)
            viewModel.onSearchValueChanged("")
            delay(300)

            // Then
            Truth.assertThat(viewModel.pokemonListState.pokemons).isEqualTo(pokemonListUI)
            Truth.assertThat(viewModel.pokemonListState.loading).isFalse()
            Truth.assertThat(viewModel.pokemonListState.error).isNull()
        }
    }
}