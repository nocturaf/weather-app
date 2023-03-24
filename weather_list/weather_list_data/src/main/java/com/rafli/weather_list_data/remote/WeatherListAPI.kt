package com.rafli.weather_list_data.remote

import com.rafli.core.util.Resource
import com.rafli.weather_list_data.remote.dto.WeatherDto
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherListAPI {

    companion object {
        private const val APP_ID = "054b6ebfbe016a697d30b30ac6f8d0ae"
    }

    @GET("weather")
    suspend fun getWeatherByCityName(
        @Query("q") cityName: String,
        @Query("appId") appId: String = APP_ID
    ): WeatherDto
}