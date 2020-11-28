package com.agromall.presentation.viewmodel

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.agromall.domain.interactor.user.GetDecodedAddress
import com.agromall.domain.interactor.user.GetWeatherData
import com.agromall.domain.model.user.WeatherData
import com.agromall.presentation.state.UIState
import com.agromall.presentation.util.handleError
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch

/**
 * [UsersViewModel] handle all interactions with the UI layer
 */
open class UsersViewModel @ViewModelInject constructor(
    private val getWeatherData: GetWeatherData,
    private val getDecodedAddress: GetDecodedAddress) : ViewModel() {

    //mutable livedata should be private to a single class
    private val _getWeatherDataLiveData: MutableLiveData<UIState<List<WeatherData>>> = MutableLiveData()
    private val _getDecodedeDataLiveData: MutableLiveData<UIState<String>> = MutableLiveData()

    //exposing MutableLivedata to corresponding Livedata objects
    val getWeatherDataLiveData: LiveData<UIState<List<WeatherData>>>
        get() = _getWeatherDataLiveData
    val getDecodedeDataLiveData: LiveData<UIState<String>>
        get() = _getDecodedeDataLiveData


    val locationString: MutableLiveData<String> = MutableLiveData()
    val selectedWeather: MutableLiveData<WeatherData> = MutableLiveData()

    /**
     * Get weather data
     */
    fun getWeatherData(param: GetWeatherData.Params?) {
        _getWeatherDataLiveData.postValue(UIState.Loading)
        viewModelScope.launch {
            getWeatherData.execute(param)
                .onEach { data ->
                    // success response
                    _getWeatherDataLiveData.postValue(UIState.Success(data))
                }.handleError { error ->
                    // error response
                    _getWeatherDataLiveData.postValue(UIState.Failed(error))
                }.collect()
        }
    }

    fun getDecodedAddress(param: GetDecodedAddress.Params) {
        _getDecodedeDataLiveData.postValue(UIState.Loading)
        viewModelScope.launch {
            getDecodedAddress.execute(param)
                .onEach { data ->
                    // success response
                    _getDecodedeDataLiveData.postValue(UIState.Success(data))
                }.handleError { error ->
                    // error response
                    _getDecodedeDataLiveData.postValue(UIState.Failed(error))
                }.collect()
        }
    }

}