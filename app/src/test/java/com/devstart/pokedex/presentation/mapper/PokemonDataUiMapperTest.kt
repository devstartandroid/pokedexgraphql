package com.devstart.pokedex.presentation.mapper

import com.devstart.pokedex.presentation.dataui.PokemonDataUi
import com.devstart.pokedex.presentation.dataui.StatsDataUi
import com.devstart.pokedex.presentation.dataui.TypeDataUi
import com.devstart.pokedex.presentation.mockedBulbasaur
import com.google.common.truth.Truth.assertThat
import io.mockk.every
import io.mockk.mockk
import org.junit.Test

class PokemonDataUiMapperTest {

    private val statsDataUiMapper: StatsDataUiMapper = mockk()
    private val typeDataUiMapper: TypeDataUiMapper = mockk()

    private val subjectMapper = PokemonDataUiMapper(statsDataUiMapper, typeDataUiMapper)

    @Test
    fun `when toItem is called SHOULD map correctly`() {
        // Given
        val expected = PokemonDataUi(
            id = 1,
            name = "Bulbasaur",
            imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/1.png",
            stats = StatsDataUi(
                hp = 53,
                attack = 65,
                defense = 27,
                speed = 40
            ),
            evolutionChain = listOf(
                PokemonDataUi(
                    id = 2,
                    name = "Ivysaur",
                    imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/2.png",
                    stats = StatsDataUi(
                        hp = 53,
                        attack = 65,
                        defense = 27,
                        speed = 40
                    ),
                    evolutionChain = null,
                    types = listOf(TypeDataUi.GRASS)
                ),
                PokemonDataUi(
                    id = 3,
                    name = "Venusaur",
                    imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/3.png",
                    stats = StatsDataUi(
                        hp = 53,
                        attack = 65,
                        defense = 27,
                        speed = 40
                    ),
                    evolutionChain = null,
                    types = listOf(TypeDataUi.GRASS)
                )
            ),
            types = listOf(TypeDataUi.GRASS)
        )

        every { statsDataUiMapper.toItem(any()) } returns StatsDataUi(
            hp = 53,
            attack = 65,
            defense = 27,
            speed = 40
        )
        every { typeDataUiMapper.toItemList(any()) } returns listOf(TypeDataUi.GRASS)

        // When
        val result = subjectMapper.toItem(mockedBulbasaur)

        // Then
        assertThat(result.id).isEqualTo(expected.id)
        assertThat(result.name).isEqualTo(expected.name)
        assertThat(result.imageUrl).isEqualTo(expected.imageUrl)
        assertThat(result.stats).isEqualTo(expected.stats)
        assertThat(result.evolutionChain).isEqualTo(expected.evolutionChain)
        assertThat(result.types).isEqualTo(expected.types)
    }
}