package com.lalosapps.flightsearch.ui.screens.main

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import com.lalosapps.flightsearch.data.local.AirportProvider
import com.lalosapps.flightsearch.ui.components.SuggestionsList
import com.lalosapps.flightsearch.ui.screens.AppViewModelProvider

@Composable
fun MainScreen(
    navigateToFlights: (Int) -> Unit,
    viewModel: MainViewModel = viewModel(factory = AppViewModelProvider.Factory)
) {
    SuggestionsList(
        suggestions = AirportProvider.list,
        onSuggestionClick = navigateToFlights
    )
}