package com.ravn.repository.people

import androidx.paging.Pager
import androidx.paging.PagingConfig
import com.apollographql.apollo.ApolloClient
import com.ravn.core.repository.PeopleRepository

class PeopleRepositoryImpl(private val apolloClient: ApolloClient) : PeopleRepository {

    override suspend fun fetchAllPeopleList(pageSize: Int?) =
        Pager(PagingConfig(pageSize ?: DEFAULT_PAGE)) {
            PeoplePagingSource(apolloClient, pageSize ?: DEFAULT_PAGE)
        }.flow

    companion object {
        const val DEFAULT_PAGE = 5
    }
}