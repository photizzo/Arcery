package com.agromall.tellerium.injection.module

import android.app.Application
import androidx.room.Room
import com.agromall.cache.db.AgromallDatabase
import com.agromall.cache.implementation.*
import com.agromall.data.repository.user.UsersCache
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton

/**
 * Module that provides all dependencies from the cache layer.
 */
@Module
@InstallIn(ApplicationComponent::class)
abstract class CacheModule {

    @Binds
    abstract fun bindUserCache(userCacheImpl: UserCacheImplementation): UsersCache
}

@Module
@InstallIn(ApplicationComponent::class)
object CacheModuleCompanion {
    @Provides
    @Singleton
    fun provideAgromallDatabase(application: Application): AgromallDatabase {
        return Room.databaseBuilder(
            application.applicationContext,
            AgromallDatabase::class.java, "tellerium.db"
        ).build()
    }
}