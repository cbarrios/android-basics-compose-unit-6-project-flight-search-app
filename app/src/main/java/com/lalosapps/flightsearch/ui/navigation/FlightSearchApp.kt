package com.lalosapps.flightsearch.ui.navigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.lalosapps.flightsearch.ui.screens.flights.FlightsScreen
import com.lalosapps.flightsearch.ui.screens.main.MainScreen

@Composable
fun FlightSearchApp() {
    val navController = rememberNavController()
    Scaffold(
        modifier = Modifier.fillMaxSize()
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = Route.MAIN,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(route = Route.MAIN) {
                MainScreen(
                    navigateToFlights = { airportId ->
                        navController.navigate(
                            Route.Flights.createRoute(airportId)
                        ) {
                            launchSingleTop = true
                        }
                    }
                )
            }
            composable(
                route = Route.Flights.ROUTE,
                arguments = listOf(
                    navArgument(Route.Flights.A1_INT_AIRPORT_ID) {
                        type = NavType.IntType
                    }
                )
            ) {
                FlightsScreen()
            }
        }
    }
}