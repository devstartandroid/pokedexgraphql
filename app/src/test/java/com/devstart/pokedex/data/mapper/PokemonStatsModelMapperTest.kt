package com.devstart.pokedex.data.mapper

import com.devstart.pokedex.data.repository.statsResponse
import com.devstart.pokedex.domain.model.Stats
import org.junit.Assert
import org.junit.Test

class PokemonStatsModelMapperTest {
    private val mapper = PokemonStatsModelMapper()

    @Test
    fun `when toDomain called SHOULD mapper correctly`() {
        // Given
        val expected = Stats(
            hp = 53,
            attack = 65,
            defense = 27,
            speed = 40
        )

        // When
        val mapped = mapper.toDomain(statsResponse)

        // Then
        Assert.assertEquals(expected.hp, mapped.hp)
        Assert.assertEquals(expected.attack, mapped.attack)
        Assert.assertEquals(expected.defense, mapped.defense)
        Assert.assertEquals(expected.speed, mapped.speed)
    }

}