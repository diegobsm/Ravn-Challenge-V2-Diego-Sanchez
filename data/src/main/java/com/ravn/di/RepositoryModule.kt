package com.ravn.di

import com.ravn.core.repository.PeopleRepository
import com.ravn.repository.PeopleRepositoryImpl
import org.koin.dsl.module

val repositoryModule = module {
    single<PeopleRepository> {
        PeopleRepositoryImpl(get(), get())
    }
}