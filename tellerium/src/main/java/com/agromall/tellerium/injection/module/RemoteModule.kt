package com.agromall.tellerium.injection.module

import com.agromall.data.repository.user.UserRemote
import com.agromall.remote.APIServiceFactory
import com.agromall.remote.GeoAPIService
import com.agromall.remote.WeatherAPIService
import com.agromall.remote.implementation.UserRemoteImplementation
import com.agromall.tellerium.BuildConfig
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton

/**
 * Module that provides all dependencies from the remote layer.
 */
@Module
@InstallIn(ApplicationComponent::class)
abstract  class RemoteModule {
    @Binds
    abstract fun bindUserRemote(userRemoteImpl: UserRemoteImplementation): UserRemote
}

@InstallIn(ApplicationComponent::class)
@Module
object RemoteModuleCompanion{
    /**
     * This companion object annotated as a module is necessary in order to provide dependencies
     * statically in case the wrapping module is an abstract class (to use binding)
     */

    /**
     * set user token to the api service
     */
    @Provides
    @Singleton
    fun provideWeatherRemoteApiService(): WeatherAPIService {
        return APIServiceFactory.makeWeatherRemoteService(BuildConfig.DEBUG)
    }

    /**
     * set user token to the api service
     */
    @Provides
    @Singleton
    fun provideGeoRemoteApiService(): GeoAPIService {
        return APIServiceFactory.makeGeoRemoteService(BuildConfig.DEBUG)
    }
}