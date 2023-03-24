package com.rafli.weather_list_domain.model

data class WeatherData(
    var cityName: String = "",
    var weatherStatus: String = "",
    var temperature: Float = 0f,
    var humidity: Int = 0,
    var dt: Int = 0,
    var windSpeed: Float = 0f
)