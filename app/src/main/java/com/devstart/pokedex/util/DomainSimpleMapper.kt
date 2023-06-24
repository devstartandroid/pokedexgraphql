package com.devstart.pokedex.util


/**
 * Used to map object to domain without caring about updates on the domain objects,
 * normally used with a list.clear()
 * (without parentId)
 */
interface DomainListSimpleMapper<out Domain, in Response : Any?> {
    fun toDomainList(responseList: List<Response>): List<Domain> {
        return responseList.map { toDomain(it) }
    }

    fun toDomain(responseObject: Response): Domain
}


interface DomainObjectSimpleMapper<out Domain, in Response : Any?> {
    fun toDomain(responseObject: Response): Domain
}



