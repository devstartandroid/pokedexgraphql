package com.devstart.pokedex.util

interface ItemDomainMapper<D, I> : ItemToDomainMapper<D, I>, DomainToItemMapper<D, I>

interface DomainToItemMapper<D, I> {
    fun toItem(domainObject: D): I

    fun toItemList(domainObjectList: List<D>): List<I> {
        return domainObjectList.map { toItem(it) }
    }
}

interface ItemToDomainMapper<D, I> {
    fun toDomain(item: I): D

    fun toDomainList(itemList: List<I>): List<D> {
        return itemList.map { toDomain(it) }
    }
}

interface ItemToNullableDomainMapper<D, I> {
    fun toDomain(item: I?): D?

    fun toDomainList(itemList: List<I?>): List<D?> {
        return itemList.map { toDomain(it) }
    }
}

interface ItemResponseMapper<I, A> : ItemToResponseMapper<I, A>, ResponseToItemMapper<I, A>

interface ItemToResponseMapper<I, A> {
    fun toApollo(item: I): A

    fun toApolloList(itemList: List<I>): List<A> {
        return itemList.map { toApollo(it) }
    }
}

interface ResponseToItemMapper<I, A> {
    fun toItem(responseObject: A): I

    fun toItemList(responseList: List<A>): List<I> {
        return responseList.map { toItem(it) }
    }
}