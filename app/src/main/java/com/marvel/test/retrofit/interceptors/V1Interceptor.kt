package com.marvel.test.retrofit.interceptors

import com.marvel.test.BuildConfig
import okhttp3.HttpUrl
import okhttp3.Interceptor

fun getV1Interceptor(): Interceptor {

    return Interceptor { chain ->

        val newUrl: HttpUrl = chain.request().url
            .newBuilder()
            .addQueryParameter(
                "apikey",
                BuildConfig.MARVEL_API_KEY
            )
            .build()
        // Headers
        val newRequest = chain.request()
            .newBuilder()
            .url(newUrl)
            .build()

        chain.proceed(newRequest)
    }
}