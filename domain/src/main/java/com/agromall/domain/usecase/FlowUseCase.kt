package com.agromall.domain.usecase

import com.agromall.domain.executor.PostExecutionThread
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn


/**
 * Abstract class for a Flow UseCase that returns an instance of a [Flow].
 */
abstract class  FlowUseCase<T, in Params> constructor(
    private val postExecutionThread: PostExecutionThread
) {

    protected abstract suspend fun buildFlowUseCase(params: Params? = null): Flow<T>

    open suspend fun execute(params: Params? = null): Flow<T> {
        return this.buildFlowUseCase(params)
            .flowOn(postExecutionThread.schedulerContext)
    }
}