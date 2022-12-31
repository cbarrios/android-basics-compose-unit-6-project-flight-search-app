package com.lalosapps.flightsearch.ui.screens

import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.createSavedStateHandle
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.lalosapps.flightsearch.FlightSearchApplication
import com.lalosapps.flightsearch.ui.screens.flights.FlightsViewModel
import com.lalosapps.flightsearch.ui.screens.main.MainViewModel

/**
 * Provides Factory to create instance of ViewModel for the entire app
 */
object AppViewModelProvider {
    val Factory = viewModelFactory {
        // Initializer for MainViewModel
        initializer {
            MainViewModel(
                application().appContainer.appRepository
            )
        }

        // Initializer for FlightsViewModel
        initializer {
            FlightsViewModel(
                this.createSavedStateHandle()
            )
        }
    }
}

/**
 * Extension function to queries for [Application] object and returns an instance of
 * [FlightSearchApplication].
 */
fun CreationExtras.application(): FlightSearchApplication =
    (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as FlightSearchApplication)