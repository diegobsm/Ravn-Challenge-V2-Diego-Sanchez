package com.ravn.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.ravn.database.model.PeopleEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface PeopleDao {

    @Query("SELECT * FROM PeopleEntity")
    suspend fun getAllPeople(): List<PeopleEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun savePeople(peopleList: List<PeopleEntity>): LongArray

    @Query("DELETE FROM PeopleEntity")
    suspend fun clearPeople(): Int
}