package com.lalosapps.flightsearch.data.local

import com.lalosapps.flightsearch.data.local.room.Airport

object AirportProvider {

    var list = listOf<Airport>()
        private set

    fun cacheAirports(list: List<Airport>) {
        this.list = list
    }
}