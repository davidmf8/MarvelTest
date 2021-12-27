package com.marvel.test.retrofit.implementation

import com.marvel.test.retrofit.api.ICharacterApi
import com.marvel.test.retrofit.commons.BaseApi
import com.marvel.test.retrofit.commons.ResultHandler
import com.marvel.test.retrofit.dto.CharactersDTO

class CharacterApi(private val api: ICharacterApi) : BaseApi() {
    suspend fun getCharacters(offset: Int): ResultHandler<CharactersDTO> {
        return request(call = { api.getCharacters(offset) })
    }

    suspend fun getCharacterDetail(id: Int): ResultHandler<CharactersDTO> {
        return request(call = { api.getCharacterDetail(id) })
    }
}