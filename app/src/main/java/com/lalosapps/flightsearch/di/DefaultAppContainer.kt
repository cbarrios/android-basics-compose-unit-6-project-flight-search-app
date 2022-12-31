package com.lalosapps.flightsearch.di

import android.content.Context
import com.lalosapps.flightsearch.data.local.datastore.LocalDataSource
import com.lalosapps.flightsearch.data.local.datastore.PreferencesDataStore
import com.lalosapps.flightsearch.data.local.datastore.dataStore
import com.lalosapps.flightsearch.data.repository.AppRepository
import com.lalosapps.flightsearch.data.repository.DefaultAppRepository

class DefaultAppContainer(private val context: Context) : AppContainer {

    private val localDataSource: LocalDataSource by lazy {
        PreferencesDataStore(context.dataStore)
    }

    override val appRepository: AppRepository by lazy {
        DefaultAppRepository(localDataSource)
    }
}