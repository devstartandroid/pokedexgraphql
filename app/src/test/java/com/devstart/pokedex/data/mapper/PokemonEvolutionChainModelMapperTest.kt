package com.devstart.pokedex.data.mapper

import com.devstart.pokedex.data.repository.pokemonIvysaurSpeciesResponse
import com.devstart.pokedex.domain.model.Pokemon
import org.junit.Assert
import org.junit.Test

class PokemonEvolutionChainModelMapperTest {
    private val mapper = PokemonEvolutionChainModelMapper()

    @Test
    fun `when toDomain called SHOULD mapper correctly`() {
        // Given
        val expected = Pokemon(
            id = 2,
            name = "Ivysaur",
            type = emptyList(),
            imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/2.png",
            stats = null,
            evolutionChain = null
        )

        // When
        val mapped = mapper.toDomain(pokemonIvysaurSpeciesResponse)

        // Then
        Assert.assertEquals(expected.id, mapped.id)
        Assert.assertEquals(expected.name, mapped.name)
        Assert.assertEquals(expected.type, mapped.type)
        Assert.assertEquals(expected.imageUrl, mapped.imageUrl)
        Assert.assertEquals(expected.stats, mapped.stats)
        Assert.assertEquals(expected.evolutionChain, mapped.evolutionChain)
    }

}