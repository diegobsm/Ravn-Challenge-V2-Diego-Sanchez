package com.ravn.repository

import AllPeopleListQuery
import androidx.lifecycle.LiveData
import com.apollographql.apollo.ApolloClient
import com.apollographql.apollo.coroutines.await
import com.apollographql.apollo.exception.ApolloException
import com.ravn.core.model.HomeWorld
import com.ravn.core.model.People
import com.ravn.core.model.Specie
import com.ravn.core.model.Vehicle
import com.ravn.core.repository.PeopleRepository
import com.ravn.core.util.Resource
import com.ravn.database.dao.PeopleDao
import com.ravn.database.model.PeopleEntity
import com.ravn.util.NetworkBoundResource

class PeopleRepositoryImpl(val apolloClient: ApolloClient, val peopleDao: PeopleDao) : PeopleRepository {

    override suspend fun fetchAllPeopleList(
        pageSize: Int?,
        nextPageCursor: String,
        isFirstPage: Boolean
    ): LiveData<Resource<List<People>>> = NetworkBoundResource.create(
        shouldFetch = {
            true
        },
        query = {
            peopleDao.getAllPeople().map {
                it.toCoreModel()
            }
        },
        fetch = { dbResult ->
            try {
                val data = apolloClient.query(
                    AllPeopleListQuery(
                        pageSize = pageSize ?: DEFAULT_PAGE,
                        allPeopleAfter = nextPageCursor ?: ""
                    )
                ).await()

                val result: MutableList<PeopleEntity> = mutableListOf()
                data.data?.allPeople?.people?.forEach { people ->
                    people?.let { person ->
                        val vehicles = mutableListOf<Vehicle>()
                        person.vehicleConnection?.vehicles?.forEach { vehicle ->
                            vehicles.add(Vehicle(vehicle?.id ?: "", vehicle?.name, vehicle?.model))
                        }
                        val entity = PeopleEntity(
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
                            ),
                            lastCursor = data.data?.allPeople?.pageInfo?.endCursor ?: "",
                            hasNextPage = data.data?.allPeople?.pageInfo?.hasNextPage
                        )
                        result.add(entity)
                    }
                }
                result
            } catch (ex: ApolloException) {
                emit(Resource.error(ex, dbResult))
                null
            }
        },
        saveFetchResult = { response ->
            if (isFirstPage) {
                peopleDao.clearPeople()
            }
            peopleDao.savePeople(response)
        }
    )

    companion object {
        const val DEFAULT_PAGE = 5
    }
}