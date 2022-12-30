package com.lalosapps.flightsearch

import android.app.Application
import com.lalosapps.flightsearch.di.AppContainer
import com.lalosapps.flightsearch.di.DefaultAppContainer

class FlightSearchApplication : Application() {

    lateinit var appContainer: AppContainer
    override fun onCreate() {
        super.onCreate()
        appContainer = DefaultAppContainer(this)
    }
}