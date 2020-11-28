package com.agromall.data.repository.user

import com.agromall.domain.interactor.user.GetDecodedAddress
import com.agromall.domain.interactor.user.GetWeatherData
import com.agromall.domain.model.user.WeatherData
import kotlinx.coroutines.flow.Flow

/**
 * Interface defining methods for the data operations related to [Farmer].
 * This is to be implemented by external data source layers, setting the requirements for the
 * operations that need to be implemented
 */
interface UserDataStore {
    /**
     * Save weather data
     */
    suspend fun saveWeatherData(param: List<WeatherData>)

    /**
     * Get weather data
     */
    fun getWeatherData(data: GetWeatherData.Params): Flow<List<WeatherData>>

    fun decodeAddressFromLatAndLng(param: GetDecodedAddress.Params): Flow<String>
}