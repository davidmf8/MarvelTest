package com.marvel.test.repository.character

import com.marvel.test.retrofit.commons.ResultHandler
import com.marvel.test.retrofit.dto.CharactersDTO

interface ICharacterRepository {
    suspend fun getCharacters(offset: Int): ResultHandler<CharactersDTO>
}