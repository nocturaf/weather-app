package com.rafli.weather_list_domain.repository

import com.rafli.core.util.Resource
import com.rafli.weather_list_domain.model.WeatherData

interface WeatherListRepository {
    suspend fun getWeatherData(cityName: String): Resource<WeatherData>
}