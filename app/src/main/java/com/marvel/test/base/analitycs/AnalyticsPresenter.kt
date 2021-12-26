package com.marvel.test.base.analitycs

import androidx.lifecycle.ViewModel
import com.marvel.test.usecase.interactors.analytics.IAnalyticsUseCase

class AnalyticsPresenter(private val analyticsUseCase: IAnalyticsUseCase) : IAnalyticsPresenter,
    ViewModel() {

    override fun trackView(screenName: String?, screenClass: String) {
        analyticsUseCase.trackView(screenName, screenClass)
    }
}
