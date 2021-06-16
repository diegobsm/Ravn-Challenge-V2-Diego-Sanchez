package com.ravn.repository.people

import com.ravn.core.model.HomeWorld
import com.ravn.core.model.People
import com.ravn.core.model.Specie
import com.ravn.core.model.Vehicle

object PeopleFactory {
    fun createPeople(): People {
        return People(
            id = "cGVvcGxlOjE=",
            name = "Luke Skywalker",
            eyeColor = "blue",
            hairColor = "blond",
            skinColor = "fair",
            birthYear = "19BBY",
            vehiclesConnection = listOf(
                Vehicle(
                    id = "dmVoaWNsZXM6MTQ=",
                    name = "Snowspeeder",
                    model = "t-47 airspeeder"
                ), Vehicle(id = "dmVoaWNsZXM6MzA=", name = "Imperial Speeder Bike", model = "74-Z speeder bike")
            ),
            species = Specie(id = "", name = null, homeWorld = HomeWorld(name = null))
        )
    }
}