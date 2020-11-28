package com.agromall.domain.interactor.user

import com.agromall.domain.executor.PostExecutionThread
import com.agromall.domain.model.user.WeatherData
import com.agromall.domain.repository.UserRepository
import com.agromall.domain.usecase.FlowUseCase
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 * Use case for log in user
 */
class GetWeatherData @Inject constructor(
    val repository: UserRepository,
    postExecutionThread: PostExecutionThread
) : FlowUseCase<List<WeatherData>, GetWeatherData.Params>(postExecutionThread) {

    override suspend fun buildFlowUseCase(params: Params?): Flow<List<WeatherData>> {
        return repository.getWeatherData(params)
    }

    data class Params(
        val lat: Double,
        val lng: Double
    )
}