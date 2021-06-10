package com.ravn.challenge

import android.app.Application
import com.ravn.challenge.di.presentationModule
import com.ravn.core.di.interactionModule
import com.ravn.di.apiModule
import com.ravn.di.dataBaseModule
import com.ravn.di.repositoryModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.module.Module

class RavnChallengeApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@RavnChallengeApplication)
            androidLogger()
            modules(loadModule())
        }
    }

    private fun loadModule(): List<Module> =
        listOf(
            presentationModule,
            apiModule,
            repositoryModule,
            dataBaseModule,
            interactionModule
        )
}