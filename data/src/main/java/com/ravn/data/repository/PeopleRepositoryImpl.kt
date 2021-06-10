package com.ravn.data.repository

import com.ravn.core.model.HomeWorld
import com.ravn.core.model.Person
import com.ravn.core.model.Specie
import com.ravn.core.model.Vehicle
import com.ravn.core.repository.PeopleRepository
import com.ravn.core.util.Response

class PeopleRepositoryImpl : PeopleRepository {

    override suspend fun fetchAllPeopleList(nextPageCursor: String, isFirstPage: Boolean): Response<List<Person>> {
        return Response.success(
            listOf(
                Person(
                    "",
                    "",
                    "",
                    "",
                    "",
                    "",
                    listOf(
                        Vehicle(
                            "",
                            "",
                            ""
                        )
                    ),
                    Specie(
                        "",
                        "",
                        HomeWorld("")
                    )
                )
            )
        )
    }
}