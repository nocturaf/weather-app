package com.rafli.weather_list_presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.rafli.core.util.UiEvent

@Composable
fun WeatherListScreen(
    onNavigate: (UiEvent.Navigate) -> Unit
) {
    MaterialTheme {
        Column(modifier = Modifier.fillMaxSize()) {
            Text(text = "Hello Weather")
        }
    }
}