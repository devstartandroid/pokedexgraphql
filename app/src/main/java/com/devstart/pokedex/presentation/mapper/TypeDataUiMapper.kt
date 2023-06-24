package com.devstart.pokedex.presentation.mapper

import com.devstart.pokedex.domain.model.Type
import com.devstart.pokedex.presentation.dataui.TypeDataUi
import com.devstart.pokedex.util.ItemDomainMapper

class TypeDataUiMapper : ItemDomainMapper<Type, TypeDataUi> {
    override fun toItem(domainObject: Type): TypeDataUi =
        TypeDataUi.valueOf(domainObject.name)

    override fun toDomain(item: TypeDataUi): Type {
        TODO("Not yet implemented")
    }


}