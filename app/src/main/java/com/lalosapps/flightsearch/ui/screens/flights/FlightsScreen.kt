package com.lalosapps.flightsearch.ui.screens.flights

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.lalosapps.flightsearch.ui.screens.AppViewModelProvider

@Composable
fun FlightsScreen(
    viewModel: FlightsViewModel = viewModel(factory = AppViewModelProvider.Factory)
) {
    val airportId = viewModel.airportIdState.collectAsState().value
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Text(text = "Airport Id: $airportId")
    }
}