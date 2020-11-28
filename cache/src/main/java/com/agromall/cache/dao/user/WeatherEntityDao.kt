package com.agromall.cache.dao.user

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.agromall.cache.db.constants.DBConstants
import com.agromall.cache.model.user.CachedWeatherData
import kotlinx.coroutines.flow.Flow

/**
 * Provides data access methods for [CachedWeatherData]
 */
@Dao
abstract class WeatherEntityDao {
    @Query("SELECT * FROM ${DBConstants.Weather.TABLE_NAME}")
    abstract fun getWeatherData(): Flow<List<CachedWeatherData>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract suspend fun save(user: List<CachedWeatherData>)

    @Query("DELETE FROM ${DBConstants.Weather.TABLE_NAME}")
    abstract suspend fun clear()
}