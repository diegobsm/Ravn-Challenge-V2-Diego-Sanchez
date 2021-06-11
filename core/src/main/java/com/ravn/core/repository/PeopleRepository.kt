package com.ravn.core.repository

import androidx.paging.PagingData
import com.ravn.core.model.People
import kotlinx.coroutines.flow.Flow

interface PeopleRepository {
    suspend fun fetchAllPeopleList(pageSize: Int? = null): Flow<PagingData<People>>
}