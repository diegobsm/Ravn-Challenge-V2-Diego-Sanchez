package com.ravn.core.repository

import com.ravn.core.model.Person
import com.ravn.core.util.Response

interface PeopleRepository {
    suspend fun fetchAllPeopleList(nextPageCursor: String, isFirstPage: Boolean): Response<List<Person>>
}