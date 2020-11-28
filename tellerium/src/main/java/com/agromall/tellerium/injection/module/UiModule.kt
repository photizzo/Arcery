package com.agromall.tellerium.injection.module

import com.agromall.domain.executor.PostExecutionThread
import com.agromall.tellerium.UiThread
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.components.ApplicationComponent

/**
 * Module that provides all dependencies from the mobile-ui package/layer and injects all activities.
 */
@Module
@InstallIn(ApplicationComponent::class)
abstract class UiModule {

    @Binds
    abstract fun bindPostExecutionThread(uiThread: UiThread): PostExecutionThread
}