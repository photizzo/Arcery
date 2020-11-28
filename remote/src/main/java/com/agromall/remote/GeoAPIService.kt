package com.agromall.remote

import com.google.gson.JsonObject
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.Url

interface GeoAPIService {
    @GET("maps/api/geocode/json")
    fun reverseGeoCodeLatAndLng(
        @Query("key") apiKey: String = api.googleMapsApiKey,
        @Query("latlng") latlng: String
    ): GenericResponse<JsonObject>
}