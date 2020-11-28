package com.agromall.cache.mapper.user

import com.agromall.cache.mapper.EntityMapper
import com.agromall.cache.model.user.CachedWeatherData
import com.agromall.domain.model.user.WeatherData
import javax.inject.Inject

/**
 * Map a [CachedUserEntity] instance to and from a [Farmer] instance when data is moving between
 * this later and the Data layer
 */
open class WeatherEntityMapper @Inject constructor() :
    EntityMapper<List<CachedWeatherData>, List<WeatherData>> {

    /**
     * Map a [WeatherData] instance to a [CachedWeatherData] instance
     */
    override fun mapToCached(type: List<WeatherData>): List<CachedWeatherData> {
        return type.map {
            CachedWeatherData(
                it.date,
                it.iconCode,
                it.weatherDescription,
                it.icon,
                it.min,
                it.max,
                it.speed,
                it.humidity,
                it.feelsLike
            )
        }
    }

    /**
     * Map a [CachedWeatherData] instance to a [WeatherData] instance
     */
    override fun mapFromCached(type: List<CachedWeatherData>): List<WeatherData> {
        return type.map {
            WeatherData(
                it.date,
                it.iconCode,
                it.weatherDescription,
                it.icon,
                it.min,
                it.max,
                it.speed,
                it.humidity,
                it.feelsLike
            )
        }
    }
}