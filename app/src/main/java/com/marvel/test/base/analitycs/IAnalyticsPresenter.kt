package com.marvel.test.base.analitycs

interface IAnalyticsPresenter {
    fun trackView(screenName: String?, screenClass: String)
}
