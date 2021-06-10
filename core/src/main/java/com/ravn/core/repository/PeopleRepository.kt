package com.ravn.core.repository

import androidx.lifecycle.LiveData
import com.ravn.core.model.People
import com.ravn.core.util.Resource

interface PeopleRepository {
    suspend fun fetchAllPeopleList(
        pageSize: Int? = null,
        nextPageCursor: String,
        isFirstPage: Boolean
    ): LiveData<Resource<List<People>>>
}