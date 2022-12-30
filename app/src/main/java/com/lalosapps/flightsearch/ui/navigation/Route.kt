package com.lalosapps.flightsearch.ui.navigation

object Route {

    const val MAIN = "main"

    object Flights {
        private const val default = "flights"
        const val A1_INT_AIRPORT_ID = "airportId"
        const val ROUTE = "$default/{$A1_INT_AIRPORT_ID}"
        fun createRoute(airportId: Int): String {
            return "$default/$airportId"
        }
    }
}