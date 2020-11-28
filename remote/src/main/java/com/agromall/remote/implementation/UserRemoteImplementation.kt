package com.agromall.remote.implementation

import com.agromall.data.repository.user.UserRemote
import com.agromall.domain.interactor.user.GetDecodedAddress
import com.agromall.domain.interactor.user.GetWeatherData
import com.agromall.domain.model.user.WeatherData
import com.agromall.remote.GeoAPIService
import com.agromall.remote.WeatherAPIService
import com.agromall.remote.util.NetworkResponse
import com.agromall.remote.util.getCity
import com.agromall.remote.util.getFormattedAddress
import com.agromall.remote.util.getState
import com.google.gson.JsonObject
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject


class UserRemoteImplementation @Inject constructor(
    private val weatherApiService: WeatherAPIService,
    private val geoAPIService: GeoAPIService) : UserRemote {
    override fun getWeatherData(data: GetWeatherData.Params): Flow<List<WeatherData>> {
        return flow {
            val response = weatherApiService.getWeatherData(lat = data.lat, lng = data.lng)
            when (response) {
                is NetworkResponse.Success -> emit(response.body.list.map {
                    WeatherData(
                        it.date * 1000,
                        it.weatherData.firstOrNull()?.id ?: 0,
                        it.weatherData.firstOrNull()?.description.toString(),
                        it.weatherData.firstOrNull()?.icon ?: "",
                        (it.temperature.min - 273.15),
                        (it.temperature.max - 273.15),
                        it.speed,
                        it.humidity,
                        (it.feelsLike.day - 273.15)
                    )
                }) // request succeded
                is NetworkResponse.ApiError -> emit(throw Throwable(response.body.message)) // request failed
                is NetworkResponse.NetworkError -> emit(
                    throw response.error ?: Throwable("Network Error")
                )// network error
                is NetworkResponse.UnknownError -> emit(
                    throw response.error ?: Throwable("An error occurred")
                )// unknown error happened
            }
        }
    }

    override fun decodeAddressFromLatAndLng(param: GetDecodedAddress.Params): Flow<String> {
        var formattedAddress = ""
        var city = ""
        var state = ""
        return flow {
            val response = geoAPIService.reverseGeoCodeLatAndLng(latlng = "$param.lat,$param.lng")
            when (response) {
                is NetworkResponse.Success -> {
                    val json = JsonObject()
                    val status = json.get("status").asString
                    if (status == "OK") {
                        val resultsArray = json.getAsJsonArray("results")
                        formattedAddress = resultsArray.getFormattedAddress()
                        for (element in resultsArray) {
                            if (city.isNotEmpty()) break //city exists break the array
                            city =
                                element.asJsonObject.getAsJsonArray("address_components").getCity()
                        }
                        for (element in resultsArray) {
                            if (state.isNotEmpty()) break //city exists break the array
                            state =
                                element.asJsonObject.getAsJsonArray("address_components").getState()
                        }
                    }
                    if (city.isEmpty() || state.isEmpty()) {
                        emit(throw Throwable("Error obtaining city and state"))
                        return@flow
                    }
                    emit(formattedAddress)
                } // request succeded
                is NetworkResponse.ApiError -> emit(throw Throwable(response.body.message)) // request failed
                is NetworkResponse.NetworkError -> emit(
                    throw response.error ?: Throwable("Network Error")
                )// network error
                is NetworkResponse.UnknownError -> emit(
                    throw response.error ?: Throwable("An error occurred")
                )// unknown error happened
            }
        }
    }
}