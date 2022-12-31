package com.lalosapps.flightsearch.data.local

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update

object FlightProvider {

    val saveableFlights =
        AirportProvider.list.groupBy { it.code }.mapValues { it.key.getSaveableFlights() }

    val favorites = MutableStateFlow(emptyList<SaveableFlight>())

    fun updateFavorites(list: List<SaveableFlight>) {
        favorites.update { list }
    }
}

fun String.getSaveableFlights(): List<SaveableFlight> {
    val mine = AirportProvider.list.filter { it.code == this }
    val notMine = AirportProvider.list.filterNot { it.code == this }
    val myAirport = mine.first()
    var countId = myAirport.id * notMine.size
    val list = notMine.map {
        SaveableFlight(
            id = countId++,
            departureCode = this,
            departureName = myAirport.name,
            destinationCode = it.code,
            destinationName = it.name,
            isFavorite = false
        )
    }
    return list
}