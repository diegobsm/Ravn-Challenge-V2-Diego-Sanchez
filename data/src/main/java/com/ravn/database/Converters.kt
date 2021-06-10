package com.ravn.database

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.ravn.core.model.Specie
import com.ravn.core.model.Vehicle

class Converters {

    @TypeConverter
    fun fromVehiclesToString(value: List<Vehicle>?): String? {
        return Gson().toJson(
            if (value.isNullOrEmpty()) {
                listOf()
            } else {
                value
            }
        )
    }

    @TypeConverter
    fun toVehicles(value: String?): List<Vehicle>? {
        return (
                Gson().fromJson(
                    value,
                    Array<Vehicle>::class.java
                ) as Array<Vehicle>
                ).toList()
    }

    @TypeConverter
    fun fromSpecie(value: Specie?): String =
        Gson().toJson(value)

    @TypeConverter
    fun toSpecie(value: String?): Specie? =
        Gson().fromJson(value, Specie::class.java)
}