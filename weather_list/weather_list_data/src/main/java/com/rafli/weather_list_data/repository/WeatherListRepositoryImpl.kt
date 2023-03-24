package com.rafli.weather_list_data.repository

import com.rafli.core.util.Resource
import com.rafli.weather_list_data.mapper.toWeatherData
import com.rafli.weather_list_data.remote.WeatherListAPI
import com.rafli.weather_list_data.remote.dto.WeatherDto
import com.rafli.weather_list_domain.model.WeatherData
import com.rafli.weather_list_domain.repository.WeatherListRepository
import retrofit2.HttpException
import java.io.IOException

class WeatherListRepositoryImpl(
    private val api: WeatherListAPI
) : WeatherListRepository {

    private suspend fun getWeatherListFromApi(cityName: String): WeatherDto? {
        val remoteWeatherData = try {
            api.getWeatherByCityName(cityName)
        } catch (e: IOException) {
            e.printStackTrace()
            null
        } catch (e: HttpException) {
            e.printStackTrace()
            null
        }

        // cache new response from api
        // :TODO

        return remoteWeatherData
    }

    override suspend fun getWeatherData(cityName: String): Resource<WeatherData> {
        val remoteWeatherData = getWeatherListFromApi(cityName)
        return Resource.Success(remoteWeatherData?.toWeatherData())
    }
}