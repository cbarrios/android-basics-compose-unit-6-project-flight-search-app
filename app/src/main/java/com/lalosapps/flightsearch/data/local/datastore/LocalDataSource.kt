package com.lalosapps.flightsearch.data.local.datastore

import kotlinx.coroutines.flow.Flow

interface LocalDataSource {

    suspend fun saveSearchQuery(query: String): Boolean

    fun getSearchQueryStream(): Flow<String>
}