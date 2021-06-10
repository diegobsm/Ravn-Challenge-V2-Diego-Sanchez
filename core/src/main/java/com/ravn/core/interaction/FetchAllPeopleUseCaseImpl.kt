package com.ravn.core.interaction

import com.ravn.core.model.Person
import com.ravn.core.repository.PeopleRepository
import com.ravn.core.util.Response

class FetchAllPeopleUseCaseImpl(private val peopleRepository: PeopleRepository) : FetchAllPeopleListUseCase {
    override suspend fun invoke(nextPageCursor: String, isFirstLoad: Boolean): Response<List<Person>> =
        peopleRepository.fetchAllPeopleList(nextPageCursor, isFirstLoad)
}