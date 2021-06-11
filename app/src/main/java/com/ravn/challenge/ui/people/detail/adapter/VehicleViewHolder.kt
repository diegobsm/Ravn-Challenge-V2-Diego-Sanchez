package com.ravn.challenge.ui.people.detail.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.ravn.challenge.R
import com.ravn.challenge.databinding.ItemVehicleBinding
import com.ravn.core.model.Vehicle

class VehicleViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    private val binding: ItemVehicleBinding? = DataBindingUtil.bind(view)

    fun bind(vehicle: Vehicle?) {
        binding?.viewModel = ItemVehicleViewModel(vehicle)
    }

    companion object {
        fun create(parent: ViewGroup): VehicleViewHolder {
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_vehicle, parent, false)
            return VehicleViewHolder(view)
        }
    }
}