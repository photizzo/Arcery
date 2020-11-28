package com.agromall.data.implementation

import com.agromall.data.source.user.UserDataStoreFactory
import com.agromall.domain.interactor.user.GetDecodedAddress
import com.agromall.domain.interactor.user.GetWeatherData
import com.agromall.domain.model.user.WeatherData
import com.agromall.domain.repository.UserRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flatMapConcat
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class UserDataRepository @Inject constructor(
    private val factory: UserDataStoreFactory
) : UserRepository {
    override fun getWeatherData(param: GetWeatherData.Params?): Flow<List<WeatherData>> {
        val cache = factory.retrieveCacheDataStore().getWeatherData(param!!)
        val remote = factory.retrieveRemoteDataStore().getWeatherData(param!!).map {
            factory.retrieveCacheDataStore().saveWeatherData(it)
            it
        }
        return cache.flatMapConcat {
            // Control fetching of weather data to every 2 days to help API Key
            if (it.filter { (it.date * 1000) > System.currentTimeMillis() }.count() < 2) {
                remote
            } else {
                flowOf(it)
            }
        }
    }

    override fun decodeAddressFromLatAndLng(param: GetDecodedAddress.Params): Flow<String> {
        return factory.retrieveRemoteDataStore().decodeAddressFromLatAndLng(param)
    }
}