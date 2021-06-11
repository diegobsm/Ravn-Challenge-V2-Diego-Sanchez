package com.ravn.challenge.ui.people.detail

import androidx.databinding.ObservableBoolean
import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel
import com.ravn.core.model.People

class PeopleDetailViewModel : ViewModel() {

    val screenName = ObservableField("")
    val eyeObserver = ObservableField("")
    val hairObserver = ObservableField("")
    val skinObserver = ObservableField("")
    val birthObserver = ObservableField("")

    val hasVehicleObservable = ObservableBoolean(true)

    fun setupInfo(people: People?) {
        screenName.set(people?.name)
        eyeObserver.set(people?.eyeColor)
        hairObserver.set(people?.hairColor)
        skinObserver.set(people?.skinColor)
        birthObserver.set(people?.birthYear)
    }
}