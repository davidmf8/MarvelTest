package com.marvel.test.repository.character

import com.marvel.test.retrofit.commons.ResultHandler
import com.marvel.test.retrofit.dto.MarvelCharactersDTO
import com.marvel.test.retrofit.implementation.CharacterApi

class CharacterRepository(private val api: CharacterApi): ICharacterRepository {
    override suspend fun getMarvelCharacters(offset: Int): ResultHandler<MarvelCharactersDTO> {
        return api.getMarvelCharacters(offset)
    }
}