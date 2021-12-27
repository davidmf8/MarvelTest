package com.marvel.test.repository.character

import com.marvel.test.retrofit.commons.ResultHandler
import com.marvel.test.retrofit.dto.CharacterDTO

interface ICharacterRepository {
    suspend fun getCharacters(offset: Int): ResultHandler<List<CharacterDTO>>
    suspend fun getCharacterDetail(id: Int): ResultHandler<CharacterDTO>
}