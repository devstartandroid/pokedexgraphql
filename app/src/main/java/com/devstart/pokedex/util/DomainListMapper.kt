package com.devstart.pokedex.util


/**
 * Used to map object to domain without caring about updates on the domain objects,
 * normally used with a list.clear()
 * (with parentId)
 */
interface DomainListMapper<out Domain, in Response : Any?> : DomainObjectMapper<Domain, Response> {
    fun toDomainList(responseList: List<Response>, parentId: String): List<Domain> {
        return responseList.map { toDomain(it, parentId) }
    }

}

interface DomainObjectMapper<out Domain, in Response : Any?> {
    fun toDomain(responseObject: Response, parentId: String): Domain
}



