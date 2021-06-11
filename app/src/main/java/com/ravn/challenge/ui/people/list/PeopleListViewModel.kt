package com.ravn.challenge.ui.people.list

import androidx.lifecycle.ViewModel
import androidx.paging.PagingData
import com.ravn.core.interaction.FetchAllPeopleListUseCase
import com.ravn.core.model.People
import kotlinx.coroutines.flow.Flow

class PeopleListViewModel(private val fetchAllPeopleListUseCase: FetchAllPeopleListUseCase) : ViewModel() {

    suspend fun getPeople(): Flow<PagingData<People>> =
        fetchAllPeopleListUseCase.invoke(true)
}