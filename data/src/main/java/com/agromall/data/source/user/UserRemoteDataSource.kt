package com.agromall.data.source.user

import com.agromall.data.repository.user.UserDataStore
import com.agromall.data.repository.user.UserRemote
import com.agromall.domain.interactor.user.GetDecodedAddress
import com.agromall.domain.interactor.user.GetWeatherData
import com.agromall.domain.model.user.WeatherData
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 * Implementation of the [UserDataStore] interface to provide a means of communicating
 * with the local data source
 */
class UserRemoteDataSource @Inject constructor(
    private val userRemote: UserRemote): UserDataStore {
    override suspend fun saveWeatherData(param: List<WeatherData>) {
        throw UnsupportedOperationException("Operation not supported in this layer")
    }

    override fun getWeatherData(data: GetWeatherData.Params): Flow<List<WeatherData>> {
        return userRemote.getWeatherData(data)
    }

    override fun decodeAddressFromLatAndLng(param: GetDecodedAddress.Params): Flow<String> {
        return userRemote.decodeAddressFromLatAndLng(param)
    }
}