package com.ravn.challenge.ui.people.list.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.paging.LoadState
import androidx.paging.LoadStateAdapter
import androidx.recyclerview.widget.RecyclerView
import com.ravn.challenge.R
import com.ravn.challenge.databinding.ItemLoadingStateBinding

class PeopleLoadingStateAdapter() :
    LoadStateAdapter<PeopleLoadingStateAdapter.NetworkStateItemViewHolder>() {

    override fun onBindViewHolder(holder: NetworkStateItemViewHolder, loadState: LoadState) {
        holder.bind(loadState)
    }

    override fun onCreateViewHolder(parent: ViewGroup, loadState: LoadState) =
        NetworkStateItemViewHolder(
            ItemLoadingStateBinding.bind(
                LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_loading_state, parent, false)
            )
        )

    class NetworkStateItemViewHolder(
        private val binding: ItemLoadingStateBinding,
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(loadState: LoadState) {
            with(binding) {
                pbPeople.isVisible = loadState is LoadState.Loading
                errorMsg.isVisible =
                    !(loadState as? LoadState.Error)?.error?.message.isNullOrBlank()
                errorMsg.text = (loadState as? LoadState.Error)?.error?.message
            }
        }
    }
}