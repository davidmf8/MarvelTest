package com.marvel.test.di

import org.koin.android.ext.koin.androidApplication
import org.koin.android.ext.koin.androidContext
import org.koin.core.module.Module
import org.koin.core.qualifier.named
import org.koin.dsl.module

val appModule: Module = module {

    single(named("context")) { androidContext() }
    single(named("application")) { androidApplication() }
}
