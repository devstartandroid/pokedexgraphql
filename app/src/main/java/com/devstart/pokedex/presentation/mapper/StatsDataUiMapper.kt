package com.devstart.pokedex.presentation.mapper

import com.devstart.pokedex.domain.model.Stats
import com.devstart.pokedex.presentation.dataui.StatsDataUi
import com.devstart.pokedex.util.ItemDomainMapper

class StatsDataUiMapper : ItemDomainMapper<Stats?, StatsDataUi> {
    override fun toItem(domainObject: Stats?): StatsDataUi = StatsDataUi(
        hp = domainObject?.hp ?: 0,
        attack = domainObject?.attack ?: 0,
        defense = domainObject?.defense ?: 0,
        speed = domainObject?.speed ?: 0
    )

    override fun toDomain(item: StatsDataUi): Stats {
        TODO("Not yet implemented")
    }
}