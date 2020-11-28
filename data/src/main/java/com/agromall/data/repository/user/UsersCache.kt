package com.agromall.data.repository.user

import com.agromall.domain.model.user.WeatherData
import kotlinx.coroutines.flow.Flow

/**
 * Interface defining methods for the caching of [User]. This is to be implemented by the
 * cache layer, using this interface as a way of communicating.
 */
interface UsersCache {
    /**
     * Save weather data
     */
    suspend fun saveWeatherData(param: List<WeatherData>)

    /**
     * Get weather data
     */
    fun getWeatherData(): Flow<List<WeatherData>>
}