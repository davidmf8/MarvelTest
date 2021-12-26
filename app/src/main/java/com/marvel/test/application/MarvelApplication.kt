package com.marvel.test.application

import android.app.Application
import android.util.Log
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.OnLifecycleEvent
import com.google.firebase.crashlytics.FirebaseCrashlytics
import com.marvel.test.BuildConfig
import com.marvel.test.di.AppKoinInitialization
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.loadKoinModules
import org.koin.core.context.startKoin
import org.koin.core.context.stopKoin

class MarvelApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@MarvelApplication)
            loadKoinModules(
                AppKoinInitialization.getModules()
            )
        }

        initCrashlytics()
    }

    override fun onTerminate() {
        stopKoin()
        super.onTerminate()
    }

    private fun initCrashlytics() {
        if (BuildConfig.ENABLE_CRASHLYTICS) {
            FirebaseCrashlytics.getInstance().setCrashlyticsCollectionEnabled(true)
        } else {
            FirebaseCrashlytics.getInstance().setCrashlyticsCollectionEnabled(false)
        }
    }
}