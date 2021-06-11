package com.ravn.challenge.ui.people.list.adapter

import androidx.lifecycle.ViewModel
import com.ravn.core.model.People

class ItemPeopleViewModel(val people: People?, private val listener: OnItemClick) : ViewModel() {

    fun onItemClick() {
        listener.onPeopleClick(people)
    }

    fun getSpecieAndHomeWorld(): String {
        val specieAndHomeWorld = StringBuilder()
        if (people?.species?.name.isNullOrBlank().not()) {
            specieAndHomeWorld.append(people?.species?.name)
            specieAndHomeWorld.append(AND_WORD)
        }

        if (people?.species?.homeWorld?.name.isNullOrBlank().not()) {
            specieAndHomeWorld.append(people?.species?.homeWorld?.name)
        }
        return specieAndHomeWorld.toString()
    }

    interface OnItemClick {
        fun onPeopleClick(people: People?)
    }

    companion object {
        const val AND_WORD = " and "
    }
}