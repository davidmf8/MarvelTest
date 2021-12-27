package com.marvel.test.usecase.interactors.character

import com.marvel.test.base.AppResultHandler
import com.marvel.test.bo.CharacterBO
import com.marvel.test.bo.CharacterDetailBO

interface ICharacterUseCase {
    suspend fun getCharacters(nextPage: Int): AppResultHandler<List<CharacterBO>>
    suspend fun getCharacterDetail(id: Int): AppResultHandler<CharacterDetailBO>
}