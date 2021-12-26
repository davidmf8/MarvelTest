package com.marvel.test.usecase.interactors.analytics

import android.os.Bundle
import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.analytics.ktx.logEvent

class AnalyticsUseCase(private val firebaseAnalytics: FirebaseAnalytics) : IAnalyticsUseCase {
    override fun trackView(screenName: String?, screenClass: String) {
        screenName?.let {
            firebaseAnalytics.logEvent(FirebaseAnalytics.Event.SCREEN_VIEW) {
                param(FirebaseAnalytics.Param.SCREEN_NAME, screenName)
                param(FirebaseAnalytics.Param.SCREEN_CLASS, screenClass)
            }
        }
    }

    override fun trackEvent(eventName: String, extraData: Bundle) {
        firebaseAnalytics.logEvent(eventName, extraData)
    }
}
