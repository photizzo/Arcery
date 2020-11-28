package com.agromall.tellerium

import androidx.hilt.work.HiltWorkerFactory
import androidx.multidex.MultiDexApplication
import androidx.work.Configuration
import com.cloudinary.android.MediaManager
import com.facebook.stetho.Stetho
import com.microsoft.appcenter.AppCenter
import com.microsoft.appcenter.analytics.Analytics
import com.microsoft.appcenter.crashes.Crashes
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber
import java.util.*
import javax.inject.Inject


@HiltAndroidApp
class App : MultiDexApplication(), Configuration.Provider {

    @Inject
    lateinit var workerFactory: HiltWorkerFactory

    override fun onCreate() {
        super.onCreate()
        setupTimber()
        installStetho()
        installCloudinary()
        initAnalytics()
    }

    private fun initAnalytics() {
        AppCenter.start(
            this, "1c338cce-4d33-4f8e-8e50-68931458b15b",
            Analytics::class.java, Crashes::class.java
        )
    }

    private fun installStetho() {
        Stetho.initializeWithDefaults(this)
    }

    private fun installCloudinary() {
        val config: MutableMap<String, String> = HashMap()
        config["cloud_name"] = "tellerium"
        MediaManager.init(this, config)
    }

    /**
     * Set up timber for logging
     */
    private fun setupTimber() {
        Timber.plant(Timber.DebugTree())
    }

    override fun getWorkManagerConfiguration() =
        Configuration.Builder()
            .setMinimumLoggingLevel(android.util.Log.INFO)
            .setWorkerFactory(workerFactory)
            .build()

}