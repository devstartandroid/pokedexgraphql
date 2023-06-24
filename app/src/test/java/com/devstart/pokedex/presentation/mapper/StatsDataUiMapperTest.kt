package com.devstart.pokedex.presentation.mapper

import com.devstart.pokedex.domain.model.Stats
import com.devstart.pokedex.presentation.dataui.StatsDataUi
import com.google.common.truth.Truth.assertThat
import org.junit.Test

class StatsDataUiMapperTest {

    val subjectMapper = StatsDataUiMapper()

    @Test
    fun `when toItem is called SHOULD map correctly`() {
        // Given
        val expected = StatsDataUi(
            hp = 53,
            attack = 65,
            defense = 27,
            speed = 40
        )

        // When
        val result = subjectMapper.toItem(
            Stats(
                hp = 53,
                attack = 65,
                defense = 27,
                speed = 40
            )
        )

        // Then
        assertThat(result.hp).isEqualTo(expected.hp)
        assertThat(result.attack).isEqualTo(expected.attack)
        assertThat(result.defense).isEqualTo(expected.defense)
        assertThat(result.speed).isEqualTo(expected.speed)
    }
}