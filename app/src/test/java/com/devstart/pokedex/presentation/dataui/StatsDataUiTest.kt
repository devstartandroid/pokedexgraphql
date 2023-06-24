package com.devstart.pokedex.presentation.dataui

import org.junit.Assert.assertEquals
import org.junit.Test

class StatsDataUiTest {
    @Test
    fun `getHpPercentage should return correct percentage when all stats are less 100`() {
        // Given
        val stats = StatsDataUi(hp = 60, attack = 70, defense = 80, speed = 90)
        val expectedPercentage = 60f / 100f

        // When
        val result = stats.getHpPercentage()

        // Then
        assertEquals(expectedPercentage, result)
    }

    @Test
    fun `getAttackPercentage should return correct percentage when all stats are less 100`() {
        // Given
        val stats = StatsDataUi(hp = 60, attack = 70, defense = 80, speed = 90)
        val expectedPercentage = 70f / 100f

        // When
        val result = stats.getAttackPercentage()

        // Then
        assertEquals(expectedPercentage, result)
    }

    @Test
    fun `getDefensePercentage should return correct percentage when all stats are less 100`() {
        // Given
        val stats = StatsDataUi(hp = 60, attack = 70, defense = 80, speed = 90)
        val expectedPercentage = 80f / 100f

        // When
        val result = stats.getDefensePercentage()

        // Then
        assertEquals(expectedPercentage, result)
    }

    @Test
    fun `getSpeedPercentage should return correct percentage when all stats are less 100`() {
        // Given
        val stats = StatsDataUi(hp = 60, attack = 70, defense = 80, speed = 90)
        val expectedPercentage = 90f / 100f

        // When
        val result = stats.getSpeedPercentage()

        // Then
        assertEquals(expectedPercentage, result)
    }

    @Test
    fun `getHpPercentage should return correct percentage when some stat is more 100`() {
        // Given
        val stats = StatsDataUi(hp = 60, attack = 70, defense = 80, speed = 150)
        val expectedPercentage = 60f / 150f

        // When
        val result = stats.getHpPercentage()

        // Then
        assertEquals(expectedPercentage, result)
    }

    @Test
    fun `getAttackPercentage should return correct percentage when some stat is more 100`() {
        // Given
        val stats = StatsDataUi(hp = 60, attack = 70, defense = 80, speed = 150)
        val expectedPercentage = 70f / 150f

        // When
        val result = stats.getAttackPercentage()

        // Then
        assertEquals(expectedPercentage, result)
    }

    @Test
    fun `getDefensePercentage should return correct percentage when some stat is more 100`() {
        // Given
        val stats = StatsDataUi(hp = 60, attack = 70, defense = 80, speed = 150)
        val expectedPercentage = 80f / 150f

        // When
        val result = stats.getDefensePercentage()

        // Then
        assertEquals(expectedPercentage, result)
    }

    @Test
    fun `getSpeedPercentage should return correct percentage when some stat is more 100`() {
        // Given
        val stats = StatsDataUi(hp = 60, attack = 70, defense = 80, speed = 150)
        val expectedPercentage = 150f / 150f

        // When
        val result = stats.getSpeedPercentage()

        // Then
        assertEquals(expectedPercentage, result)
    }

}