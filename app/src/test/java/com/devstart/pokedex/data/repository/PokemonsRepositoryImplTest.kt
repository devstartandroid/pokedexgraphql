package com.devstart.pokedex.data.repository

import com.devstart.pokedex.data.datasource.PokemonRemoteDataSource
import com.devstart.pokedex.data.mapper.PokemonModelMapper
import com.devstart.pokedex.data.mapper.PokemonsModelMapper
import com.devstart.pokedex.domain.repository.PokemonsRepository
import io.mockk.coEvery
import io.mockk.every
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Before
import org.junit.Test


class PokemonsRepositoryImplTest {
    private val remoteDataSource: PokemonRemoteDataSource = mockk()
    private val pokemonsModelMapper: PokemonsModelMapper = mockk()
    private val pokemonModelMapper: PokemonModelMapper = mockk()
    lateinit var repository: PokemonsRepository

    @Before
    fun setup() {
        repository = PokemonsRepositoryImpl(
            remoteDataSource, pokemonsModelMapper, pokemonModelMapper
        )
    }

    @Test
    fun `when get pokemons from remote data source should return pokemon list`() = runBlocking {
        // Given
        val expected = pokemonList
        coEvery { remoteDataSource.getPokemons() } returns pokemonsResponse
        every { pokemonsModelMapper.toDomainList(any()) } returns pokemonList

        // When
        val result = repository.getPokemons()

        // Then
        Assert.assertEquals(result, expected)
    }

    @Test(expected = RuntimeException::class)
    fun `when get pokemons from remote data source should throw exception`() {
        runBlocking {
            // Given
            coEvery { remoteDataSource.getPokemons() } throws RuntimeException("Test Error")
            every { pokemonsModelMapper.toDomainList(any()) } returns pokemonList

            // When
            repository.getPokemons()
        }
    }

    @Test(expected = RuntimeException::class)
    fun `when remote datasource returns null should throw exception`() {
        runBlocking {
            // Given
            coEvery { remoteDataSource.getPokemons() } returns getPokemonsNullDataApolloResponse
            every { pokemonsModelMapper.toDomainList(any()) } returns pokemonList

            // When
            repository.getPokemons()
        }
    }

    @Test
    fun `when get pokemon from remote data source should return pokemon`() = runBlocking {
        // Given
        val expected = pokemon1
        coEvery { remoteDataSource.getPokemon(any()) } returns getPokemonApolloResponse
        coEvery { pokemonModelMapper.toDomain(any()) } returns pokemon1

        // When
        val result = repository.getPokemon("bulbasaur")

        // Then
        Assert.assertEquals(result, expected)
    }

    @Test(expected = RuntimeException::class)
    fun `when get pokemon from remote data source returns null should throw exception`() {
        runBlocking {
            // Given
            coEvery { remoteDataSource.getPokemon(any()) } returns getPokemonNullDataApolloResponse
            coEvery { pokemonModelMapper.toDomain(any()) } returns pokemon1

            // When
            repository.getPokemon("bulbasaur")

        }
    }

    @Test(expected = RuntimeException::class)
    fun `when get pokemon from remote data source throws should throw exception`() {
        runBlocking {
            // Given
            coEvery { remoteDataSource.getPokemon(any()) } returns getPokemonNullDataApolloResponse
            coEvery { pokemonModelMapper.toDomain(any()) } returns pokemon1

            // When
            repository.getPokemon("bulbasaur")

        }
    }

}