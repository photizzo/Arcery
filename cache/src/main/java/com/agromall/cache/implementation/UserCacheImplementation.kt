package com.agromall.cache.implementation

import com.agromall.cache.db.AgromallDatabase
import com.agromall.cache.mapper.user.WeatherEntityMapper
import com.agromall.data.repository.user.UsersCache
import com.agromall.domain.model.user.WeatherData
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.flow.mapLatest
import javax.inject.Inject

/**
 * Cached implementation for retrieving and saving User instances. This class implements the
 * [UserCache] from the Data layer as it is that layers responsibility for defining the
 * operations in which data store implementation layers can carry out.
 */
@ExperimentalCoroutinesApi
class UserCacheImplementation @Inject constructor(
    val db: AgromallDatabase,
    private val cacheWeatherMapper: WeatherEntityMapper
) : UsersCache {
    override suspend fun saveWeatherData(param: List<WeatherData>) {
        db.cachedWeatherDataDao().clear()
        return db.cachedWeatherDataDao().save(cacheWeatherMapper.mapToCached(param))
    }

    override fun getWeatherData(): Flow<List<WeatherData>> {
        return db.cachedWeatherDataDao().getWeatherData().filterNotNull()
            .mapLatest { cacheWeatherMapper.mapFromCached(it) }
    }
}