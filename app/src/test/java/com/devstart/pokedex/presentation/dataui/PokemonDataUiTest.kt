package com.devstart.pokedex.presentation.dataui

import org.junit.Assert.*
import org.junit.Test

class PokemonDataUiTest {
    private val pokemonDataUi = PokemonDataUi(
        id = 1,
        name=  "Bulbasaur",
        imageUrl = "",
        stats = StatsDataUi(
            hp = 54,
            attack = 50,
            defense = 35,
            speed = 40
        ),
        evolutionChain = null,
        types = emptyList()
    )

    @Test
    fun `doesMatchSearchQuery should return true when name contains query`() {
        val query = "Bulb"
        val result = pokemonDataUi.doesMatchSearchQuery(query)

        assertTrue(result)
    }

    @Test
    fun `doesMatchSearchQuery should return false when name does not contain query`() {
        val query = "Bulb"
        val result = pokemonDataUi.doesMatchSearchQuery(query)

        assertTrue(result)
    }

    @Test
    fun `doesMatchSearchQuery should return true when name contains query, ignoring case`() {
        val query = "bULb"
        val result = pokemonDataUi.doesMatchSearchQuery(query)

        assertTrue(result)
    }

    @Test
    fun `doesMatchSearchQuery should return false when name does not contain query, ignoring case`() {
        val query = "pIkA"
        val result = pokemonDataUi.doesMatchSearchQuery(query)

        assertFalse(result)
    }

}