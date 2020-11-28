package com.agromall.data.repository.user

import com.agromall.domain.interactor.user.GetDecodedAddress
import com.agromall.domain.interactor.user.GetWeatherData
import com.agromall.domain.model.user.WeatherData
import kotlinx.coroutines.flow.Flow

interface UserRemote {
    /**
     * Get weather data
     */
    fun getWeatherData(data: GetWeatherData.Params): Flow<List<WeatherData>>

    fun decodeAddressFromLatAndLng(param: GetDecodedAddress.Params): Flow<String>
}