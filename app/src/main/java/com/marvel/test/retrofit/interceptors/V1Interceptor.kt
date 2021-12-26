package com.marvel.test.retrofit.interceptors

import com.marvel.test.BuildConfig
import com.marvel.test.extension.toMD5
import okhttp3.HttpUrl
import okhttp3.Interceptor
import java.security.MessageDigest

fun getV1Interceptor(): Interceptor {

    return Interceptor { chain ->

        val newUrl: HttpUrl = chain.request().url
            .newBuilder()
            .port(443)
            .addQueryParameter("ts", BuildConfig.MARVEL_API_TS)
            .addQueryParameter(
                "apikey",
                BuildConfig.MARVEL_PUBLIC_API_KEY
            )
            .addQueryParameter(
                "hash",
                (BuildConfig.MARVEL_API_TS + BuildConfig.MARVEL_PRIVATE_API_KEY + BuildConfig.MARVEL_PUBLIC_API_KEY).toMD5()
            )
            .build()

        // Headers
        val newRequest = chain.request()
            .newBuilder()
            .url(newUrl)
            .addHeader("Content-Type", "application/json")
            .build()

        chain.proceed(newRequest)
    }
}