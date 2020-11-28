package com.agromall.tellerium.injection.module

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext


/**
 * Module used to provide dependencies at an application-level.
 */
@Module
@InstallIn(ApplicationComponent::class)
abstract class ApplicationModule