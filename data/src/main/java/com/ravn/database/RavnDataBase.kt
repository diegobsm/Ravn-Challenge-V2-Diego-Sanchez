package com.ravn.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.ravn.database.dao.PeopleDao
import com.ravn.database.model.PeopleEntity

@Database(
    entities = [
        PeopleEntity::class
    ],
    version = 1,
    exportSchema = false
)
@TypeConverters(Converters::class)
abstract class RavnDataBase : RoomDatabase() {
    abstract fun peopleDao(): PeopleDao
}