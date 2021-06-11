package com.ravn.core.interaction

import androidx.paging.PagingData
import com.ravn.core.model.People
import com.ravn.core.repository.PeopleRepository
import kotlinx.coroutines.flow.Flow

class FetchAllPeopleUseCaseImpl(private val peopleRepository: PeopleRepository) : FetchAllPeopleListUseCase {
    override suspend fun invoke(isFirstLoad: Boolean): Flow<PagingData<People>> =
        peopleRepository.fetchAllPeopleList( isFirstPage = isFirstLoad)
}