package com.devstart.pokedex.data.mapper

import com.devstart.pokedex.GetPokemonQuery
import com.devstart.pokedex.domain.model.Pokemon
import com.devstart.pokedex.util.DomainListSimpleMapper

class PokemonEvolutionChainModelMapper : DomainListSimpleMapper<Pokemon, GetPokemonQuery.Species> {
    override fun toDomain(
        responseObject: GetPokemonQuery.Species
    ): Pokemon = Pokemon(
        id = responseObject.pokemons[0].id,
        name = responseObject.pokemons[0].name,
        type = emptyList(),
        imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/${responseObject.pokemons[0].id}.png",
        stats = null,
        evolutionChain = null
    )
}