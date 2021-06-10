package com.ravn.core.interaction

import com.ravn.core.model.Person
import com.ravn.core.util.Response

interface FetchAllPeopleListUseCase {
    suspend operator fun invoke(nextPageCursor: String, isFirstLoad: Boolean): Response<List<Person>>
}