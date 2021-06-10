package com.ravn.core.model

data class Person(
    val id: String,
    val name: String? = null,
    val eyeColor: String? = null,
    val hairColor: String? = null,
    val skinColor: String? = null,
    val birthYear: String? = null,
    val vehiclesConnection: List<Vehicle>? = null,
    val species: Specie? = null,
    val lastCursor: String = "",
    val hasNextPage: Boolean? = false
)