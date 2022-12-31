package com.lalosapps.flightsearch.data.repository

import com.lalosapps.flightsearch.data.local.datastore.LocalDataSource
import kotlinx.coroutines.flow.Flow

class DefaultAppRepository(private val localDataSource: LocalDataSource) : AppRepository {

    override suspend fun saveSearchQuery(query: String): Boolean =
        localDataSource.saveSearchQuery(query)

    override fun getSearchQueryStream(): Flow<String> = localDataSource.getSearchQueryStream()
}