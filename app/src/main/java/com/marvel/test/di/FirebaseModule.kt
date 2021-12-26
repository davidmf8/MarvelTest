package com.marvel.test.di

import com.google.firebase.analytics.FirebaseAnalytics
import org.koin.android.ext.koin.androidContext
import org.koin.core.module.Module
import org.koin.dsl.module

val firebaseModule: Module = module {
    single { FirebaseAnalytics.getInstance(androidContext()) }
}
