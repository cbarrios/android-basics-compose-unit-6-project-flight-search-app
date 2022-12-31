package com.lalosapps.flightsearch.ui.screens.flights

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.viewmodel.compose.viewModel
import com.lalosapps.flightsearch.R
import com.lalosapps.flightsearch.ui.components.FlightsView
import com.lalosapps.flightsearch.ui.screens.AppViewModelProvider

@Composable
fun FlightsScreen(
    viewModel: FlightsViewModel = viewModel(factory = AppViewModelProvider.Factory)
) {
    val flights = viewModel.flights.collectAsState().value
    FlightsView(
        title = stringResource(R.string.flights_from_code, viewModel.airportCode),
        list = flights,
        onFavoriteClick = viewModel::onFavoriteClick
    )
}