package com.ravn.core.di

import com.ravn.core.interaction.FetchAllPeopleListUseCase
import com.ravn.core.interaction.FetchAllPeopleUseCaseImpl
import org.koin.dsl.module

val interactionModule = module {
    factory<FetchAllPeopleListUseCase> {
        FetchAllPeopleUseCaseImpl(get())
    }
}