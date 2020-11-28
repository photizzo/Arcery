package com.agromall.cache.model.user

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.agromall.cache.db.constants.DBConstants

@Entity(tableName = DBConstants.Weather.TABLE_NAME)
data class CachedWeatherData(
    @PrimaryKey val date: Long,
    val iconCode: Int,
    val weatherDescription: String,
    val icon: String,
    val min: Double,
    val max: Double,
    val speed: Double,
    val humidity: Double,
    val feelsLike: Double
)