package com.devstart.pokedex.data.mapper

import androidx.compose.ui.text.capitalize
import androidx.compose.ui.text.intl.Locale
import androidx.compose.ui.text.toUpperCase
import com.devstart.pokedex.GetPokemonQuery
import com.devstart.pokedex.GetPokemonsQuery
import com.devstart.pokedex.domain.model.Pokemon
import com.devstart.pokedex.domain.model.Stats
import com.devstart.pokedex.domain.model.Type
import com.devstart.pokedex.util.DomainListSimpleMapper

class PokemonStatsModelMapper : DomainListSimpleMapper<Stats, List<GetPokemonQuery.Stat>> {
    override fun toDomain(
        responseObject: List<GetPokemonQuery.Stat>
    ): Stats = Stats(
        hp = responseObject.find { it.stat?.name == "hp" }?.value ?: 0,
        attack = responseObject.find { it.stat?.name == "attack" }?.value ?: 0,
        defense = responseObject.find { it.stat?.name == "defense" }?.value ?: 0,
        speed = responseObject.find { it.stat?.name == "speed" }?.value ?: 0
    )
}