package com.ravn.core.interaction

import androidx.lifecycle.LiveData
import com.ravn.core.model.People
import com.ravn.core.repository.PeopleRepository
import com.ravn.core.util.Resource

class FetchAllPeopleUseCaseImpl(private val peopleRepository: PeopleRepository) : FetchAllPeopleListUseCase {
    override suspend fun invoke(nextPageCursor: String, isFirstLoad: Boolean): LiveData<Resource<List<People>>> =
        peopleRepository.fetchAllPeopleList(nextPageCursor = nextPageCursor, isFirstPage = isFirstLoad)
}