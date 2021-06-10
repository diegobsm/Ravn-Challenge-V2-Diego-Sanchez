package com.ravn.core.interaction

import androidx.lifecycle.LiveData
import com.ravn.core.model.People
import com.ravn.core.util.Resource

interface FetchAllPeopleListUseCase {
    suspend operator fun invoke(nextPageCursor: String, isFirstLoad: Boolean): LiveData<Resource<List<People>>>
}