package com.lalosapps.flightsearch.ui.screens.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lalosapps.flightsearch.data.local.AirportProvider
import com.lalosapps.flightsearch.data.local.FlightProvider
import com.lalosapps.flightsearch.data.repository.AppRepository
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

class MainViewModel(private val appRepository: AppRepository) : ViewModel() {

    private val _uiState = MutableStateFlow(MainUiState())
    private val _favorites = FlightProvider.favorites

    val uiState: StateFlow<MainUiState> =
        combine(
            _uiState,
            _favorites
        ) { mainUiState, favorites ->
            mainUiState.copy(favorites = favorites)
        }.stateIn(
            viewModelScope,
            SharingStarted.WhileSubscribed(5_000),
            MainUiState()
        )

    init {
        viewModelScope.launch {
            val query = appRepository.getSearchQueryStream().first()
            if (query.isNotEmpty()) processSearchQuery(query)
            _uiState.update { it.copy(isLoading = false) }
        }
    }

    fun onQueryChange(query: String) {
        viewModelScope.launch {
            appRepository.saveSearchQuery(query)
        }
        processSearchQuery(query)
    }

    private fun processSearchQuery(query: String) {
        if (query.isEmpty()) {
            _uiState.update { it.copy(searchQuery = query) }
            return
        }
        val lowercaseQuery = query.lowercase()
        val list = AirportProvider.list
        val suggestions = list.filter {
            it.code.lowercase().contains(lowercaseQuery) || it.name.lowercase()
                .contains(lowercaseQuery)
        }
        _uiState.update { it.copy(searchQuery = query, suggestions = suggestions) }
    }

    fun onFavoriteClick(flightId: Int) {
        val favorites = _favorites.value
        val found = favorites.find { it.id == flightId }!!
        FlightProvider.updateFavorites(favorites - found)
    }
}