package com.ravn.di

import com.ravn.core.repository.PeopleRepository
import com.ravn.repository.people.PeopleRepositoryImpl
import org.koin.dsl.module

val repositoryModule = module {
    single<PeopleRepository> {
        PeopleRepositoryImpl(get())
    }
}