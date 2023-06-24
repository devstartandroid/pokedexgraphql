package com.devstart.pokedex.data.service

import com.apollographql.apollo3.ApolloClient

fun getApolloClient() = ApolloClient.Builder()
    .serverUrl("https://beta.pokeapi.co/graphql/v1beta")
    .build()