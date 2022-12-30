package com.lalosapps.flightsearch.ui.components

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.lalosapps.flightsearch.data.local.Airport

@Composable
fun SuggestionsList(
    suggestions: List<Airport>,
    onSuggestionClick: (Int) -> Unit,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = modifier.fillMaxSize()
    ) {
        items(suggestions, key = { it.id }) {
            SuggestionItem(suggestion = it, onClick = onSuggestionClick)
        }
    }
}