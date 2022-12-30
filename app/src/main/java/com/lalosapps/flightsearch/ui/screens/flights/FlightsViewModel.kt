package com.lalosapps.flightsearch.ui.screens.flights

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.lalosapps.flightsearch.ui.navigation.Route
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class FlightsViewModel(
    savedStateHandle: SavedStateHandle,
) : ViewModel() {

    private val airportId: Int = savedStateHandle[Route.Flights.A1_INT_AIRPORT_ID] ?: -1

    private val _airportIdState = MutableStateFlow(-1)
    val airportIdState = _airportIdState.asStateFlow()

    init {
        _airportIdState.value = airportId
    }
}