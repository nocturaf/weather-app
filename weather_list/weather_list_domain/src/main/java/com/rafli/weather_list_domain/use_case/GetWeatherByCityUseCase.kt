package com.rafli.weather_list_domain.use_case

import com.rafli.core.util.Resource
import com.rafli.weather_list_domain.model.WeatherData
import com.rafli.weather_list_domain.repository.WeatherListRepository

class GetWeatherByCityUseCase(
    private val weatherListRepository: WeatherListRepository
) {
    suspend operator fun invoke(cityName: String): Resource<WeatherData> {
        return weatherListRepository.getWeatherData(cityName)
    }
}