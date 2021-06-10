package com.ravn.util.mapper

// Used to map the ResponseModel to a EntityModel
// Clean Architecture

interface RoomMapper<out T : Any> {
    fun mapToRoomEntity(): T
}