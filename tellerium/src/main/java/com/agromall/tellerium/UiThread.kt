package com.agromall.tellerium

import com.agromall.domain.executor.PostExecutionThread
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext

/**
 * MainThread (UI Thread) implementation based on a [Scheduler]
 * which will execute actions on the Android UI thread
 */
class UiThread @Inject internal constructor() : PostExecutionThread {

    override val schedulerContext: CoroutineContext
        get() = Dispatchers.IO
}