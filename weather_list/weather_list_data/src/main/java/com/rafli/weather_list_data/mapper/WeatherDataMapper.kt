package com.rafli.weather_list_data.mapper

import com.rafli.weather_list_data.remote.dto.WeatherDto
import com.rafli.weather_list_domain.model.WeatherData

fun WeatherDto.toWeatherData(): WeatherData {
    return WeatherData(
        cityName = name,
        weatherStatus = weatherList.first().main,
        temperature = temperature.temp,
        humidity = temperature.humidity,
        dt = dt,
        windSpeed = wind.speed
    )
}