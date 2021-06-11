package com.ravn.core.interaction

import androidx.paging.PagingData
import com.ravn.core.model.People
import kotlinx.coroutines.flow.Flow

interface FetchAllPeopleListUseCase {
    suspend operator fun invoke(isFirstLoad: Boolean): Flow<PagingData<People>>
}