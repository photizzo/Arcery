package com.agromall.tellerium.injection.module

import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent

/**
 * Module that provides all dependencies from the presentation package/layer.
 */
@Module
@InstallIn(ApplicationComponent::class)
abstract class PresentationModule