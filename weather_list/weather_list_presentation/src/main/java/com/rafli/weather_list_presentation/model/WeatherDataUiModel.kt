package com.rafli.weather_list_presentation.model

import com.rafli.weather_list_domain.model.WeatherData

data class WeatherDataUiModel(
    val weatherData: WeatherData = WeatherData(),
    val isLoading: Boolean = false,
    val isError: Boolean = false
)