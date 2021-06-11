package com.ravn.challenge.ui.people.list.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.ravn.challenge.R
import com.ravn.challenge.databinding.ItemPeopleBinding
import com.ravn.core.model.People

class PeopleViewHolder(view: View, private val listener: OnItemPeopleClick) : RecyclerView.ViewHolder(view),
    ItemPeopleViewModel.OnItemClick {
    private val binding: ItemPeopleBinding? = DataBindingUtil.bind(view)
    fun bind(people: People?) {
        binding?.viewModel = ItemPeopleViewModel(people, this)
    }

    override fun onPeopleClick(people: People?) {
        listener.onPeopleSelected(people)
    }

    interface OnItemPeopleClick {
        fun onPeopleSelected(people: People?)
    }

    companion object {
        fun create(parent: ViewGroup, listener: OnItemPeopleClick): PeopleViewHolder {
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_people, parent, false)
            return PeopleViewHolder(view, listener)
        }
    }
}