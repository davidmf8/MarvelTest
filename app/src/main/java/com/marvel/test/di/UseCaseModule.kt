package com.marvel.test.di

import com.marvel.test.usecase.interactors.analytics.AnalyticsUseCase
import com.marvel.test.usecase.interactors.analytics.IAnalyticsUseCase
import org.koin.core.module.Module
import org.koin.dsl.module

val useCaseModule: Module = module {
    single<IAnalyticsUseCase> { AnalyticsUseCase(get()) }
}
