package com.rafli.weather_list_data.remote.dto

import com.squareup.moshi.Json

data class WeatherDto(
    @field:Json(name = "coord")
    val coordinate: Coordinate = Coordinate(),
    @field:Json(name = "weather")
    val weatherList: List<WeatherItem> = emptyList(),
    @field:Json(name = "base")
    val base: String = "",
    @field:Json(name = "main")
    val temperature: Temperature = Temperature(),
    @field:Json(name = "visibility")
    val visibility: Int = 0,
    @field:Json(name = "wind")
    val wind: Wind = Wind(),
    @field:Json(name = "clouds")
    val clouds: Clouds = Clouds(),
    @field:Json(name = "dt")
    val dt: Int = 0,
    @field:Json(name = "sys")
    val sys: Sys = Sys(),
    @field:Json(name = "timezone")
    val timezone: Int = 0,
    @field:Json(name = "id")
    val id: Int = 0,
    @field:Json(name = "name")
    val name: String = "",
    @field:Json(name = "cod")
    val cod: Int = 0,
)

data class Coordinate(
    @field:Json(name = "lon")
    val longitude: Float = 0f,
    @field:Json(name = "lat")
    val latitude: Float = 0f,
)

data class WeatherItem(
    @field:Json(name = "id")
    val id: Int = 0,
    @field:Json(name = "main")
    val main: String = "",
    @field:Json(name = "description")
    val description: String = "",
    @field:Json(name = "icon")
    val icon: String = "",
)

data class Temperature(
    @field:Json(name = "temp")
    val temp: Float = 0f,
    @field:Json(name = "feels_like")
    val feelsLike: Float = 0f,
    @field:Json(name = "temp_min")
    val tempMin: Float = 0f,
    @field:Json(name = "temp_max")
    val tempMax: Float = 0f,
    @field:Json(name = "pressure")
    val pressure: Int = 0,
    @field:Json(name = "humidity")
    val humidity: Int = 0,
    @field:Json(name = "sea_level")
    val seaLevel: Int = 0,
    @field:Json(name = "grnd_level")
    val groundLevel: Int = 0
)

data class Wind(
    @field:Json(name = "speed")
    val speed: Float = 0f,
    @field:Json(name = "deg")
    val deg: Int = 0,
    @field:Json(name = "weather")
    val gust: Float = 0f,
)

data class Clouds(
    @field:Json(name = "all")
    val all: Int = 0
)

data class Sys(
    @field:Json(name = "country")
    val countryId: String = "",
    @field:Json(name = "sunrise")
    val sunrise: Int = 0,
    @field:Json(name = "sunset")
    val sunset: Int = 0
)