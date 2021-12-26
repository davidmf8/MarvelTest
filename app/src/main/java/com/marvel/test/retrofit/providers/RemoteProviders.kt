package com.marvel.test.retrofit.providers

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.marvel.test.BuildConfig
import com.marvel.test.constants.RetrofitConstants.RETROFIT_CONNECTION_TIMEOUT
import com.marvel.test.retrofit.api.ICharacterApi
import com.marvel.test.retrofit.implementation.CharacterApi
import com.marvel.test.retrofit.interceptors.getLoggingInterceptor
import com.marvel.test.retrofit.interceptors.getV1Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

fun getDefaultHttpClient(): OkHttpClient {
    return OkHttpClient().newBuilder()
        .connectTimeout(RETROFIT_CONNECTION_TIMEOUT, TimeUnit.SECONDS)
        .readTimeout(RETROFIT_CONNECTION_TIMEOUT, TimeUnit.SECONDS)
        .writeTimeout(RETROFIT_CONNECTION_TIMEOUT, TimeUnit.SECONDS)
        .addInterceptor(getV1Interceptor())
        .addInterceptor(getLoggingInterceptor())
        .build()
}

fun getRemoteGson(): Gson {
    val gsonBuilder = GsonBuilder()
    return gsonBuilder.create()
}

fun getMarvelRetrofit(HttpClient: OkHttpClient, gson: Gson): Retrofit {
    return Retrofit.Builder()
        .client(HttpClient)
        .baseUrl(BuildConfig.MARVEL_API_URL)
        .addConverterFactory(GsonConverterFactory.create(gson))
        .addCallAdapterFactory(CoroutineCallAdapterFactory())
        .build()
}

fun getCharacterApi(retrofit: Retrofit): CharacterApi =
    CharacterApi(
        retrofit.create(ICharacterApi::class.java)
    )


