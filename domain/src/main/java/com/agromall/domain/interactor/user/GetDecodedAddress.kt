package com.agromall.domain.interactor.user

import com.agromall.domain.executor.PostExecutionThread
import com.agromall.domain.repository.UserRepository
import com.agromall.domain.usecase.FlowUseCase
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 * Use case for log in user
 */
class GetDecodedAddress @Inject constructor(
    val repository: UserRepository,
    postExecutionThread: PostExecutionThread
) : FlowUseCase<String, GetDecodedAddress.Params>(postExecutionThread) {

    override suspend fun buildFlowUseCase(params: Params?): Flow<String> {
        if (params == null) throw IllegalArgumentException("Param cannot be null.")
        return repository.decodeAddressFromLatAndLng(params)
    }

    data class Params(
        val lat: Double,
        val lng: Double
    )
}