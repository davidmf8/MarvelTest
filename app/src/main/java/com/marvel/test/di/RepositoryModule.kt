package com.marvel.test.di

import com.marvel.test.repository.character.CharacterRepository
import com.marvel.test.repository.character.ICharacterRepository
import com.marvel.test.retrofit.providers.getCharacterApi
import com.marvel.test.retrofit.providers.getDefaultHttpClient
import com.marvel.test.retrofit.providers.getMarvelRetrofit
import com.marvel.test.retrofit.providers.getRemoteGson
import org.koin.core.module.Module
import org.koin.core.qualifier.named
import org.koin.dsl.module

val repositoryModule: Module = module {
    // Gson
    single(named("gson")) { getRemoteGson() }

    // Httpclient
    single(named("HttpDefaultClient")) { getDefaultHttpClient() }

    // Retrofit providers
    single(named("RetrofitMarvelApi")) {
        getMarvelRetrofit(
            get(named("HttpDefaultClient")),
            get(named("gson"))
        )
    }

    //APIs
    single {
        getCharacterApi(
            get(named("RetrofitMarvelApi"))
        )
    }

    //Repository
    single<ICharacterRepository>{CharacterRepository(get())}

}