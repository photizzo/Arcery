package com.agromall.domain.model.user

data class WeatherData(
    val date: Long,
    val iconCode: Int,
    val weatherDescription: String,
    val icon: String,
    val min: Double,
    val max: Double,
    val speed: Double,
    val humidity: Double,
    val feelsLike: Double
)