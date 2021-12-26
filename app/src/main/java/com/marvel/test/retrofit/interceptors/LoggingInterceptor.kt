package com.marvel.test.retrofit.interceptors

import com.marvel.test.BuildConfig
import okhttp3.logging.HttpLoggingInterceptor

/**
 * Login interceptor
 * @return HttpLoggingInterceptor
 */
fun getLoggingInterceptor(): HttpLoggingInterceptor {
    val logging = HttpLoggingInterceptor()
    if (BuildConfig.DEBUG) {
        logging.level = HttpLoggingInterceptor.Level.BODY
    } else {
        logging.level = HttpLoggingInterceptor.Level.NONE
    }
    return logging
}