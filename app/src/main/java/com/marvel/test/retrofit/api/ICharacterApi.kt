package com.marvel.test.retrofit.api

import com.marvel.test.retrofit.dto.CharactersDTO
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ICharacterApi {

    @GET("characters")
    suspend fun getCharacters(@Query("offset") offset: Int): Response<CharactersDTO>

    @GET("characters/{characterId}")
    suspend fun getCharacterDetail(@Path("characterId") characterId: Int): Response<CharactersDTO>
}