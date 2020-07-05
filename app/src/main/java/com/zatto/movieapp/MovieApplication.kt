package com.zatto.movieapp

import android.app.Application
import com.zatto.movieapp.di.movieModule
import com.zatto.movieapp.di.networkModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class MovieApplication : Application(){
    override fun onCreate() {
        super.onCreate()
        configureDi()
    }

    private fun configureDi() {
        startKoin {
            androidLogger()
            androidContext(applicationContext)
            modules(listOf(networkModule, movieModule))
        }
    }
}