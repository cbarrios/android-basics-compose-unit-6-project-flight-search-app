package com.lalosapps.flightsearch.ui.screens.main

import com.lalosapps.flightsearch.data.local.Airport
import com.lalosapps.flightsearch.data.local.SaveableFlight

data class MainUiState(
    val searchQuery: String = "",
    val favorites: List<SaveableFlight> = emptyList(),
    val suggestions: List<Airport> = emptyList(),
    val isLoading: Boolean = true
)
