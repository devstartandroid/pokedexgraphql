package com.devstart.pokedex.data.mapper

import androidx.compose.ui.text.capitalize
import androidx.compose.ui.text.intl.Locale
import androidx.compose.ui.text.toUpperCase
import com.devstart.pokedex.GetPokemonsQuery
import com.devstart.pokedex.domain.model.Pokemon
import com.devstart.pokedex.domain.model.Type
import com.devstart.pokedex.util.DomainListSimpleMapper

class PokemonsModelMapper : DomainListSimpleMapper<Pokemon, GetPokemonsQuery.GetPokemonsResponse> {
    override fun toDomain(
        responseObject: GetPokemonsQuery.GetPokemonsResponse
    ): Pokemon = Pokemon(
        id = responseObject.id,
        name = responseObject.name.capitalize(Locale.current),
        type = responseObject.pokemon[0].types.map {
            Type.valueOf(it.type?.name?.toUpperCase(Locale.current) ?: "UNKNOWN")
        },
        imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/${responseObject.id}.png",
        stats = null,
        evolutionChain = null
    )
}