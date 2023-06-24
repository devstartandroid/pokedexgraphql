package com.devstart.pokedex.presentation.dataui

data class PokemonDataUi(
    val id: Int,
    val name: String,
    val imageUrl: String,
    val stats: StatsDataUi,
    val evolutionChain: List<PokemonDataUi>?,
    val types: List<TypeDataUi>
) {
    fun doesMatchSearchQuery(query: String): Boolean {
        return name.contains(query, ignoreCase = true)
    }
}
