package com.lalosapps.flightsearch.di

import android.content.Context
import com.lalosapps.flightsearch.data.local.datastore.LocalSearchDataSource
import com.lalosapps.flightsearch.data.local.source.LocalDataSource
import com.lalosapps.flightsearch.data.local.datastore.PreferencesDataStore
import com.lalosapps.flightsearch.data.local.datastore.dataStore
import com.lalosapps.flightsearch.data.local.room.FlightsDao
import com.lalosapps.flightsearch.data.local.room.FlightsDatabase
import com.lalosapps.flightsearch.data.local.source.DefaultLocalDataSource
import com.lalosapps.flightsearch.data.repository.AppRepository
import com.lalosapps.flightsearch.data.repository.DefaultAppRepository

class DefaultAppContainer(private val context: Context) : AppContainer {

    private val searchDataSource: LocalSearchDataSource by lazy {
        PreferencesDataStore(context.dataStore)
    }

    private val flightsDataSource: FlightsDao by lazy {
        FlightsDatabase.getDatabase(context).flightsDao
    }

    private val localDataSource: LocalDataSource by lazy {
        DefaultLocalDataSource(
            searchDataSource,
            flightsDataSource
        )
    }

    override val appRepository: AppRepository by lazy {
        DefaultAppRepository(localDataSource)
    }
}