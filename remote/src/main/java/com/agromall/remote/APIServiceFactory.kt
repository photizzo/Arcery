package com.agromall.remote

import com.agromall.remote.util.NetworkResponseAdapterFactory
import com.squareup.moshi.*
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import okio.IOException
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit


/**
 * Provide "make" methods to create instances of [APIService]
 * and its related dependencies, such as OkHttpClient, Gson, etc.
 */
object APIServiceFactory {

    const val WEATHER_BASE_URL = "https://api.openweathermap.org/"
    const val WEATHER_API_KEY = "1d369d8a214bc5d3b32ad99e58f93e73"

    /**
     * Safe method for providing API service instance between debug an release
     */
    fun makeWeatherRemoteService(isDebug: Boolean): WeatherAPIService {
        val okHttpClient = makeOkHttpClient(
            makeLoggingInterceptor(isDebug)
        )
        return makeWeatherRemoteService(makeMoshi(), okHttpClient)
    }

    fun makeGeoRemoteService(isDebug: Boolean): GeoAPIService {
        val okHttpClient = makeOkHttpClient(
            makeLoggingInterceptor(isDebug)
        )
        return makeGeoRemoteService(makeMoshi())
    }


    /**
     * Creates the APIService instance
     */
    private fun makeWeatherRemoteService(moshi: Moshi, okHttpClient: OkHttpClient): WeatherAPIService {
        val retrofit = Retrofit.Builder()
            .baseUrl(WEATHER_BASE_URL)
//            .client(okHttpClient)
            .addCallAdapterFactory(NetworkResponseAdapterFactory())
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build()
        return retrofit.create(WeatherAPIService::class.java)
    }

    /**
     * Creates the APIService instance
     */
    private fun makeGeoRemoteService(moshi: Moshi): GeoAPIService {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://maps.googleapis.com/")
//            .client(okHttpClient)
            .addCallAdapterFactory(NetworkResponseAdapterFactory())
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build()
        return retrofit.create(GeoAPIService::class.java)
    }

    /**
     * Defines the OkHttpClient instance
     */
    private fun makeOkHttpClient(
        httpLoggingInterceptor: HttpLoggingInterceptor
    ): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(httpLoggingInterceptor)
            .connectTimeout(300, TimeUnit.SECONDS)
            .readTimeout(300, TimeUnit.SECONDS)
            .build()
    }

    /**
     * Provides a Gson instance that can also handle error json type
     */
    private fun makeMoshi(): Moshi {
        return Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()
    }

    /**
     * Logging interceptor for debug builds
     */
    private fun makeLoggingInterceptor(isDebug: Boolean): HttpLoggingInterceptor {
        val logging = HttpLoggingInterceptor()
        logging.level = if (isDebug)
            HttpLoggingInterceptor.Level.BODY
        else
            HttpLoggingInterceptor.Level.NONE
        return logging
    }

    class VoidJsonAdapter {
        @FromJson
        @Throws(IOException::class)
        fun fromJson(reader: JsonReader): Void? {
            return reader.nextNull()
        }

        @ToJson
        @Throws(IOException::class)
        fun toJson(writer: JsonWriter, v: Void?) {
            writer.nullValue()
        }
    }
}