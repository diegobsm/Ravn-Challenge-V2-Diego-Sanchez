package com.ravn.challenge.ui.people.detail.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ravn.core.model.Vehicle

class VehicleAdapter(private var vehicles: List<Vehicle>? = listOf()) : RecyclerView.Adapter<VehicleViewHolder>() {

    fun updateData(newData: List<Vehicle>?) {
        vehicles = newData
        notifyDataSetChanged()
    }

    override
    fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = VehicleViewHolder.create(parent)

    override fun onBindViewHolder(holder: VehicleViewHolder, position: Int) {
        holder.bind(vehicles?.get(position))
    }

    override fun getItemCount(): Int = vehicles?.size ?: 0
}