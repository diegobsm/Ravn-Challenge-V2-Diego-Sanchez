package com.ravn.di

import androidx.room.Room
import com.ravn.database.RavnDataBase
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

const val DB_NAME = "ravn_challenge_db"

val dataBaseModule = module {
    single {
        Room.databaseBuilder(
            androidContext(),
            RavnDataBase::class.java,
            DB_NAME
        ).build()
    }

    factory {
        (get() as RavnDataBase).peopleDao()
    }
}