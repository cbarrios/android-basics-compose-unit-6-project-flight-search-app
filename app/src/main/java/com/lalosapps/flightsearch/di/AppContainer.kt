package com.lalosapps.flightsearch.di

import com.lalosapps.flightsearch.data.repository.AppRepository

interface AppContainer {

    val appRepository: AppRepository
}