package com.devstart.pokedex.data.mapper

import androidx.compose.ui.text.capitalize
import androidx.compose.ui.text.intl.Locale
import androidx.compose.ui.text.toUpperCase
import com.devstart.pokedex.GetPokemonQuery
import com.devstart.pokedex.domain.model.Pokemon
import com.devstart.pokedex.domain.model.Type
import com.devstart.pokedex.util.DomainListSimpleMapper

class PokemonModelMapper(
    private val pokemonEvolutionChainModelMapper: PokemonEvolutionChainModelMapper,
    private val pokemonStatsModelMapper: PokemonStatsModelMapper
) : DomainListSimpleMapper<Pokemon, GetPokemonQuery.GetPokemonResponse> {
    override fun toDomain(
        responseObject: GetPokemonQuery.GetPokemonResponse
    ): Pokemon = Pokemon(
        id = responseObject.pokemons[0].id,
        name = responseObject.pokemons[0].name.capitalize(Locale.current),
        type = responseObject.pokemons[0].types.map {
            Type.valueOf(it.type?.name?.toUpperCase(Locale.current) ?: "UNKNOWN")
        },
        imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/${responseObject.pokemons[0].id}.png",
        stats = pokemonStatsModelMapper.toDomain(responseObject.pokemons[0].stats),
        evolutionChain = pokemonEvolutionChainModelMapper.toDomainList(
            responseObject.pokemons[0].specy?.evolutionChain?.species?.filter { it.pokemons.isNotEmpty() } ?: emptyList()
        )
    )
}