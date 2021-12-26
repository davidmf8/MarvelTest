package com.marvel.test.usecase.interactors.analytics

import android.os.Bundle

interface IAnalyticsUseCase {
    fun trackView(screenName: String?, screenClass: String)
    fun trackEvent(eventName: String, extraData: Bundle)
}
