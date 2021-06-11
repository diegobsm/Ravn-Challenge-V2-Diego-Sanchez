package com.ravn.challenge.ui.people.list.adapter

import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import com.ravn.core.model.People

class PeopleAdapter() : PagingDataAdapter<People, PeopleViewHolder>(POST_COMPARATOR) {

    override fun onBindViewHolder(holder: PeopleViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PeopleViewHolder {
        return PeopleViewHolder.create(parent)
    }

    companion object {
        val POST_COMPARATOR = object : DiffUtil.ItemCallback<People>() {
            override fun areContentsTheSame(oldItem: People, newItem: People): Boolean =
                oldItem == newItem

            override fun areItemsTheSame(oldItem: People, newItem: People): Boolean =
                oldItem.id == newItem.id

        }
    }
}