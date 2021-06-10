package com.ravn.di

import com.apollographql.apollo.ApolloClient
import org.koin.dsl.module

const val SERVER_URL = "https://swapi-graphql.netlify.app/.netlify/functions/index"

val apiModule = module {
    single {
        ApolloClient.builder()
            .serverUrl(SERVER_URL)
            .build()
    }
}