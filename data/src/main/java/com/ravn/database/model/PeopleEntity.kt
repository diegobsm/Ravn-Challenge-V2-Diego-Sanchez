package com.ravn.database.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.ravn.core.model.People
import com.ravn.core.model.Specie
import com.ravn.core.model.Vehicle
import com.ravn.util.mapper.CoreMapper

@Entity
data class PeopleEntity(
    @PrimaryKey
    var id: String,
    var name: String? = null,
    var eyeColor: String? = null,
    var hairColor: String? = null,
    var skinColor: String? = null,
    var birthYear: String? = null,
    var vehiclesConnection: List<Vehicle>? = null,
    var species: Specie? = null,
    val lastCursor: String = "",
    val hasNextPage: Boolean? = false
) : CoreMapper<People> {
    override fun toCoreModel() = People(
        id,
        name,
        eyeColor,
        hairColor,
        skinColor,
        birthYear,
        vehiclesConnection,
        species,
        lastCursor,
        hasNextPage
    )
}