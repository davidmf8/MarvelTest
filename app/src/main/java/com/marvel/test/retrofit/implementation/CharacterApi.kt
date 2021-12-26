package com.marvel.test.retrofit.implementation

import com.marvel.test.retrofit.api.ICharacterApi
import com.marvel.test.retrofit.commons.BaseApi
import com.marvel.test.retrofit.commons.ResultHandler
import com.marvel.test.retrofit.dto.MarvelCharactersDTO

class CharacterApi(private val api: ICharacterApi) : BaseApi() {
    suspend fun getMarvelCharacters(offset: Int): ResultHandler<MarvelCharactersDTO> {
        return request(call = { api.getCharacters(offset) })
    }
}