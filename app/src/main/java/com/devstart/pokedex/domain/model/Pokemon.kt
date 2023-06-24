package com.devstart.pokedex.domain.model

data class Pokemon(
    val id: Int,
    val name: String,
    val type: List<Type>,
    val imageUrl: String,
    val stats: Stats?,
    val evolutionChain: List<Pokemon>?
)
