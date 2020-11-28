package com.agromall.remote

import com.agromall.remote.APIServiceFactory.WEATHER_API_KEY
import com.agromall.remote.model.user.WeatherResponse
import com.agromall.remote.util.NetworkResponse
import com.google.gson.JsonObject
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.Url

object api {
    const val googleMapsApiKey = "AIzaSyAU0jXmPg1IFecKdOuZKso72p9pQnZhLbE"
    const val reverseGeoCodeUrl = "https://maps.googleapis.com/maps/api/geocode/json"
}

interface WeatherAPIService {

    @GET("/data/2.5/forecast/daily")
    suspend fun getWeatherData(
        @Query("lat") lat: Double,
        @Query("lon") lng: Double,
        @Query("APPID") apiKey: String = WEATHER_API_KEY,
        @Query("cnt") count: Int = 7
    ): GenericResponse<WeatherResponse>

    @GET("/data/2.5/forecast")
    fun getWeatherData2(
        @Query("lat") lat: Double = 35.0,
        @Query("lon") lng: Double = 139.0,
        @Query("APPID") apiKey: String = WEATHER_API_KEY,
        @Query("cnt") count: Int = 7
    ): Call<WeatherResponse>

    @GET
    fun reverseGeoCodeLatAndLng(
        @Url url: String = api.reverseGeoCodeUrl,
        @Query("key") apiKey: String = api.googleMapsApiKey,
        @Query("latlng") latlng: String
    ): GenericResponse<WeatherResponse>
}
typealias GenericResponse<S> = NetworkResponse<S, Error>

@JsonClass(generateAdapter = true)
data class Error(
    @Json(name = "status")
    val status: String,

    @Json(name = "message")
    val message: String
)