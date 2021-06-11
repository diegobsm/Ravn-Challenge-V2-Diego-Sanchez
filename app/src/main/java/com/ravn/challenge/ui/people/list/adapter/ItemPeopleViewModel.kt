package com.ravn.challenge.ui.people.list.adapter

import androidx.lifecycle.ViewModel
import com.ravn.core.model.People

class ItemPeopleViewModel(val people: People?, private val listener: OnItemClick) : ViewModel() {

    fun onItemClick() {
        listener.onPeopleClick(people)
    }

    fun getSpecieAndHomeWorld(): String = "${people?.species?.name} $AND_WORD ${people?.species?.homeWorld?.name}"

    interface OnItemClick {
        fun onPeopleClick(people: People?)
    }

    companion object {
        const val AND_WORD = "and"
    }
}