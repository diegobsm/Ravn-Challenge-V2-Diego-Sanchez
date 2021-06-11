package com.ravn.repository.people

import AllPeopleListQuery
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.apollographql.apollo.ApolloClient
import com.apollographql.apollo.coroutines.await
import com.ravn.core.model.HomeWorld
import com.ravn.core.model.People
import com.ravn.core.model.Specie
import com.ravn.core.model.Vehicle
import retrofit2.HttpException
import java.io.IOException

class PeoplePagingSource(
    private val apolloClient: ApolloClient,
    private val pageSize: Int
) :
    PagingSource<String, People>() {

    var isFirstPage: Boolean = true

    override fun getRefreshKey(state: PagingState<String, People>): String? {
        return state.anchorPosition?.let { anchorPosition ->
            // This loads starting from previous page, but since PagingConfig.initialLoadSize spans
            // multiple pages, the initial load will still load items centered around
            // anchorPosition. This also prevents needing to immediately launch prepend due to
            // prefetchDistance.
            state.closestPageToPosition(anchorPosition)?.prevKey
        }
    }

    override suspend fun load(params: LoadParams<String>): LoadResult<String, People> {
        return try {
            val data = apolloClient.query(
                AllPeopleListQuery(
                    pageSize = pageSize,
                    allPeopleAfter = if (params is LoadParams.Append) params.key else "",
                    allPeopleBefore = if (params is LoadParams.Prepend) params.key else ""
                )
            ).await()

            LoadResult.Page(
                data = getPeopleList(data.data?.allPeople),
                prevKey = data.data?.allPeople?.pageInfo?.startCursor,
                nextKey = data.data?.allPeople?.pageInfo?.endCursor
            )
        } catch (e: IOException) {
            LoadResult.Error(e)
        } catch (e: HttpException) {
            LoadResult.Error(e)
        }
    }

    private fun getPeopleList(allPeople: AllPeopleListQuery.AllPeople?): List<People> {
        val result: MutableList<People> = mutableListOf()
        allPeople?.people?.forEach { people ->
            people?.let { person ->
                val vehicles = mutableListOf<Vehicle>()
                person.vehicleConnection?.vehicles?.forEach { vehicle ->
                    vehicles.add(Vehicle(vehicle?.id ?: "", vehicle?.name, vehicle?.model))
                }
                val entity = People(
                    id = person.id,
                    name = person.name,
                    eyeColor = person.eyeColor,
                    hairColor = person.hairColor,
                    skinColor = person.skinColor,
                    birthYear = person.birthYear,
                    vehiclesConnection = vehicles,
                    species = Specie(
                        person.species?.id ?: "",
                        person.species?.name,
                        HomeWorld(person.species?.homeworld?.name)
                    )
                )
                result.add(entity)
            }
        }
        return result
    }
}