package com.lalosapps.flightsearch.data.repository

import kotlinx.coroutines.flow.Flow

interface AppRepository {

    suspend fun saveSearchQuery(query: String): Boolean

    fun getSearchQueryStream(): Flow<String>
}