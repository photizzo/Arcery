package com.agromall.data.source.user

import com.agromall.data.repository.user.UserDataStore
import com.agromall.data.repository.user.UsersCache
import com.agromall.domain.interactor.user.GetDecodedAddress
import com.agromall.domain.interactor.user.GetWeatherData
import com.agromall.domain.model.user.WeatherData
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 * Implementation of the [UserDataStore] interface to provide a means of communicating
 * with the local data source
 */
class UserCacheDataSource @Inject constructor(
    private val userCache: UsersCache): UserDataStore {
    override suspend fun saveWeatherData(param: List<WeatherData>) {
        return userCache.saveWeatherData(param)
    }

    override fun getWeatherData(data: GetWeatherData.Params): Flow<List<WeatherData>> {
        return userCache.getWeatherData()
    }
    override fun decodeAddressFromLatAndLng(param: GetDecodedAddress.Params): Flow<String> {
        TODO("Not yet implemented")
    }
}