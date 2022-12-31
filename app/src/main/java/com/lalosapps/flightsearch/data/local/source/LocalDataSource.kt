package com.lalosapps.flightsearch.data.local.source

import com.lalosapps.flightsearch.data.local.datastore.LocalSearchDataSource
import com.lalosapps.flightsearch.data.local.room.FlightsDao

interface LocalDataSource : LocalSearchDataSource, FlightsDao