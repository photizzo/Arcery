package com.agromall.presentation.state

sealed class UIState<out T>{
    /**
     * Success state
     */
    data class Success<T : Any>(val body: T) : UIState<T>()

    /**
     * Failed state
     */
    data class Failed(val error: String?) : UIState<Nothing>()

    /**
     * Loading
     */
    object Loading: UIState<Nothing>()

}