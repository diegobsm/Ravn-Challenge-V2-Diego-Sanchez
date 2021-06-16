package com.ravn.repository.people

import AllPeopleListQuery
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.paging.PagingSource
import com.apollographql.apollo.ApolloClient
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlin.test.assertEquals
import androidx.paging.PagingSource.LoadParams.Refresh
import com.ravn.di.SERVER_URL
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class PeoplePagingSourceTest {

    lateinit var apolloClient: ApolloClient

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    @Before
    fun setUp() {
        apolloClient = ApolloClient.builder()
            .serverUrl(SERVER_URL)
            .build()
    }

    @Test
    fun loadReturnsPageWhenOnSuccessfulLoadOfItemKeyedData() = runBlocking {
        val people = listOf(PeopleFactory.createPeople(), PeopleFactory.createPeople())
        apolloClient.query(
            AllPeopleListQuery(
                1, "", ""
            )
        )
        val pagingSource = PeoplePagingSource(apolloClient, 1)
        assertEquals(
            expected = PagingSource.LoadResult.Page(
                data = listOf(people[0]),
                prevKey = "YXJyYXljb25uZWN0aW9uOjA=",
                nextKey = "YXJyYXljb25uZWN0aW9uOjA="
            ),
            actual = pagingSource.load(
                Refresh(
                    key = null,
                    loadSize = 1,
                    placeholdersEnabled = false
                )
            )
        )
    }
}