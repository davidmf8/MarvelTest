package com.marvel.test.repository.character

import com.marvel.test.retrofit.commons.ResultHandler
import com.marvel.test.retrofit.dto.CharactersDTO
import com.marvel.test.retrofit.implementation.CharacterApi

class CharacterRepository(private val api: CharacterApi): ICharacterRepository {
    override suspend fun getCharacters(offset: Int): ResultHandler<CharactersDTO> {
        return api.getCharacters(offset)
    }

    override suspend fun getCharacterDetail(id: Int): ResultHandler<CharactersDTO> {
        return api.getCharacterDetail(id)
    }
}