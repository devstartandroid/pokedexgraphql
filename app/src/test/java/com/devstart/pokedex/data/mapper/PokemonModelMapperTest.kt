package com.devstart.pokedex.data.mapper

import com.devstart.pokedex.data.repository.getPokemonResponse
import com.devstart.pokedex.domain.model.Pokemon
import com.devstart.pokedex.domain.model.Stats
import com.devstart.pokedex.domain.model.Type
import io.mockk.every
import io.mockk.mockk
import org.junit.Assert
import org.junit.Test

class PokemonModelMapperTest {

    private val pokemonEvolutionChainModelMapper: PokemonEvolutionChainModelMapper = mockk()
    private val pokemonStatsModelMapper: PokemonStatsModelMapper = mockk()

    private val mapper = PokemonModelMapper(
        pokemonEvolutionChainModelMapper, pokemonStatsModelMapper
    )

    @Test
    fun `when toDomain called SHOULD mapper correctly`() {
        // Given
        val evolutionMocked = listOf(
            Pokemon(
                id = 2,
                name = "Ivysaur",
                type = emptyList(),
                imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/2.png",
                stats = null,
                evolutionChain = null
            ), Pokemon(
                id = 3,
                name = "Venusaur",
                type = emptyList(),
                imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/3.png",
                stats = null,
                evolutionChain = null
            )
        )

        val mockedStats = Stats(
            hp = 53,
            attack = 65,
            defense = 27,
            speed = 40
        )

        val expected = Pokemon(
            id = 1,
            name = "Bulbasaur",
            type = listOf(Type.GRASS),
            imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/1.png",
            stats = Stats(
                hp = 53,
                attack = 65,
                defense = 27,
                speed = 40
            ),
            evolutionChain = listOf(
                Pokemon(
                    id = 2,
                    name = "Ivysaur",
                    type = emptyList(),
                    imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/2.png",
                    stats = null,
                    evolutionChain = null
                ),
                Pokemon(
                    id = 3,
                    name = "Venusaur",
                    type = emptyList(),
                    imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/3.png",
                    stats = null,
                    evolutionChain = null
                )
            )
        )

        every { pokemonEvolutionChainModelMapper.toDomainList(any()) } returns evolutionMocked
        every { pokemonStatsModelMapper.toDomain(any()) } returns mockedStats

        // When
        val mapped = mapper.toDomain(getPokemonResponse)

        // Then
        Assert.assertEquals(expected.id, mapped.id)
        Assert.assertEquals(expected.name, mapped.name)
        Assert.assertEquals(expected.type, mapped.type)
        Assert.assertEquals(expected.imageUrl, mapped.imageUrl)
        Assert.assertEquals(expected.stats, mapped.stats)
        Assert.assertEquals(expected.evolutionChain, mapped.evolutionChain)
    }
}