package com.devstart.pokedex.data.mapper

import com.devstart.pokedex.data.repository.getPokemonsResponse
import com.devstart.pokedex.domain.model.Pokemon
import com.devstart.pokedex.domain.model.Type
import org.junit.Assert
import org.junit.Test

class PokemonsModelMapperTest {
    val mapper = PokemonsModelMapper()

    @Test
    fun `when toDomain called SHOULD mapper correctly`() {
        // Given

        val expected = Pokemon(
            id = 1,
            name = "Bulbasaur",
            type = listOf(Type.GRASS),
            imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/1.png",
            stats = null,
            evolutionChain = null
        )

        // When
        val mapped = mapper.toDomain(getPokemonsResponse)

        // Then
        Assert.assertEquals(expected.id, mapped.id)
        Assert.assertEquals(expected.name, mapped.name)
        Assert.assertEquals(expected.type, mapped.type)
        Assert.assertEquals(expected.imageUrl, mapped.imageUrl)
        Assert.assertEquals(expected.stats, mapped.stats)
        Assert.assertEquals(expected.evolutionChain, mapped.evolutionChain)
    }
}