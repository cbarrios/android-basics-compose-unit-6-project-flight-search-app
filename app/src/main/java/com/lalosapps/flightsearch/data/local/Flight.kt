package com.lalosapps.flightsearch.data.local

// App requirement to save favorite table with this schema (use later with room)
data class Flight(
    val id: Int,
    val departureCode: String,
    val destinationCode: String
) {
    fun toSaveableFlight(departureName: String, destinationName: String): SaveableFlight {
        return SaveableFlight(
            id = id,
            departureCode = departureCode,
            departureName = departureName,
            destinationCode = destinationCode,
            destinationName = destinationName,
            isFavorite = true
        )
    }
}
