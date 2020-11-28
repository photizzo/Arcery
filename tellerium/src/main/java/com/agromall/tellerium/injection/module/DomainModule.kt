package com.agromall.tellerium.injection.module

import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent

/**
 * Module that provides all dependencies from the domain package/layer.
 */
@Module
@InstallIn(ApplicationComponent::class)
abstract class DomainModule