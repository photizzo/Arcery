package com.agromall.cache.db

import androidx.annotation.NonNull
import androidx.annotation.VisibleForTesting
import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import androidx.room.TypeConverters
import com.agromall.cache.converters.Converters
import com.agromall.cache.dao.user.WeatherEntityDao
import com.agromall.cache.model.user.CachedWeatherData
import javax.inject.Inject


/**
 * Provides the database instance
 */
@Database(
    entities = [
        CachedWeatherData::class
    ],
    exportSchema = false,
    version = 1
)
@TypeConverters(Converters::class)
abstract class AgromallDatabase @Inject constructor() : RoomDatabase() {

    abstract fun cachedWeatherDataDao(): WeatherEntityDao

    companion object {
        private var INSTANCE: AgromallDatabase? = null

        /**
         * Migrate from:
         * version 1 - using the SQLiteDatabase API
         * to
         * version 2 - using Room
         */
        @VisibleForTesting
        val MIGRATION_1_2: Migration =
            object : Migration(1, 2) {
                override fun migrate(@NonNull database: SupportSQLiteDatabase) {


                }
            }

        private val sLock = Any()

    }
}