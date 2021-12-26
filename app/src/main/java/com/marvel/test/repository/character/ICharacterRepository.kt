package com.marvel.test.repository.character

import com.marvel.test.retrofit.commons.ResultHandler
import com.marvel.test.retrofit.dto.MarvelCharactersDTO

interface ICharacterRepository {
    suspend fun getMarvelCharacters(offset: Int): ResultHandler<MarvelCharactersDTO>
}