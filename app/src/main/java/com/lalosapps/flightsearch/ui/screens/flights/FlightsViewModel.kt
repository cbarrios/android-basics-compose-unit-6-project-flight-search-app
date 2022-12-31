package com.lalosapps.flightsearch.ui.screens.flights

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lalosapps.flightsearch.data.local.FlightProvider
import com.lalosapps.flightsearch.data.local.SaveableFlight
import com.lalosapps.flightsearch.ui.navigation.Route
import kotlinx.coroutines.flow.*

class FlightsViewModel(
    savedStateHandle: SavedStateHandle,
) : ViewModel() {

    val airportCode: String = savedStateHandle[Route.Flights.A1_STRING_AIRPORT_ID] ?: ""

    private val saveableFlights = MutableStateFlow(emptyList<SaveableFlight>())
    private val favoritesFlights = FlightProvider.favorites
    private val combinedData: Flow<List<SaveableFlight>> =
        combine(
            saveableFlights,
            favoritesFlights
        ) { flights, favorites ->
            flights.map { flight ->
                val isFavorite = favorites.find { it.id == flight.id }?.isFavorite ?: false
                flight.copy(isFavorite = isFavorite)
            }
        }

    val flights: StateFlow<List<SaveableFlight>> =
        combinedData.stateIn(viewModelScope, SharingStarted.WhileSubscribed(5_000), emptyList())

    init {
        saveableFlights.value = FlightProvider.saveableFlights[airportCode] ?: emptyList()
    }

    fun onFavoriteClick(flightId: Int) {
        val favorites = favoritesFlights.value
        val found = favorites.find { it.id == flightId }
        if (found != null) {
            FlightProvider.updatefavorites(favorites - found)
        } else {
            val aux = saveableFlights.value
            val new = aux.find { it.id == flightId }!!.copy(isFavorite = true)
            FlightProvider.updatefavorites(favorites + new)
        }
    }
}