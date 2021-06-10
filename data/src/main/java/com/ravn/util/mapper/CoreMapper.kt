package com.ravn.util.mapper

// Used to map the EntityModel to a DomainModel
// Clean Architecture

interface CoreMapper<Model : Any> {
    abstract fun toCoreModel(): Model
}