package com.ravn.challenge.di

import com.ravn.challenge.ui.people.PeopleShareViewModel
import com.ravn.challenge.ui.people.detail.PeopleDetailViewModel
import com.ravn.challenge.ui.people.list.PeopleListViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val presentationModule = module {

    viewModel {
        PeopleShareViewModel()
    }

    viewModel {
        PeopleListViewModel(get())
    }

    viewModel {
        PeopleDetailViewModel()
    }
}