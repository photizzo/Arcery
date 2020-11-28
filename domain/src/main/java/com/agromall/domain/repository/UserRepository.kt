package com.agromall.domain.repository

import com.agromall.domain.interactor.user.GetDecodedAddress
import com.agromall.domain.interactor.user.GetWeatherData
import com.agromall.domain.model.user.WeatherData
import kotlinx.coroutines.flow.Flow

/**
 * Interface defining methods for how the data layer can pass data to and from the Domain layer.
 * This is to be implemented by the data layer, setting the requirements for the
 * operations that need to be implemented
 */
interface UserRepository {
    fun getWeatherData(param: GetWeatherData.Params?): Flow<List<WeatherData>>

    fun decodeAddressFromLatAndLng(param: GetDecodedAddress.Params): Flow<String>
}