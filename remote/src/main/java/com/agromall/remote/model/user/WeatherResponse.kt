package com.agromall.remote.model.user

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class WeatherResponse(
    @Json(name = "list") val list: List<WeatherListResponse>
)

//@JsonClass(generateAdapter = true)
data class WeatherListResponse(
    @Json(name = "dt") val date: Long,
    @Json(name = "weather") val weatherData: List<WeatherDataResponse>,
    @Json(name = "humidity") val humidity: Double,
    @Json(name = "speed") val speed: Double,
    @Json(name = "temp") val temperature: Temperature,
    @Json(name = "feels_like") val feelsLike: FeelsLike
)

//@JsonClass(generateAdapter = true)
data class WeatherDataResponse(
    @Json(name = "description") val description: String,
    @Json(name = "icon") val icon: String,
    @Json(name = "id") val id: Int
)

data class Temperature(
    val min: Double,
    val max: Double
)

data class FeelsLike(
    val day: Double
)