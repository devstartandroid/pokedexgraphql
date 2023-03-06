package com.devstart.pokedex.presentation.mapper

import com.devstart.pokedex.domain.model.Pokemon
import com.devstart.pokedex.presentation.dataui.PokemonDataUi
import com.devstart.pokedex.util.ItemDomainMapper

class PokemonDataUiMapper(
    private val statsDataUiMapper: StatsDataUiMapper,
    private val typeDataUiMapper: TypeDataUiMapper
) : ItemDomainMapper<Pokemon, PokemonDataUi> {
    override fun toItem(domainObject: Pokemon): PokemonDataUi = with (domainObject) {
        PokemonDataUi(
            id = id,
            name = name,
            imageUrl = imageUrl,
            stats = statsDataUiMapper.toItem(stats),
            evolutionChain = evolutionChain?.map { toItem(it) },
            types = typeDataUiMapper.toItemList(type)
        )
    }

    override fun toDomain(item: PokemonDataUi): Pokemon {
        TODO("Not yet implemented")
    }

}