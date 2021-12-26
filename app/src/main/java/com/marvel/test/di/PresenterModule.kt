package com.marvel.test.di

import com.marvel.test.base.analitycs.AnalyticsPresenter
import com.marvel.test.base.analitycs.IAnalyticsPresenter
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.bind
import org.koin.dsl.module

val presenterModule: Module = module {
    viewModel { AnalyticsPresenter(get()) } bind (IAnalyticsPresenter::class)
}
