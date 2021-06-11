package com.ravn.challenge.di

import com.ravn.challenge.ui.people.list.PeopleListViewModel
import org.koin.dsl.module

val presentationModule = module {
    factory {
        PeopleListViewModel(get())
    }
}