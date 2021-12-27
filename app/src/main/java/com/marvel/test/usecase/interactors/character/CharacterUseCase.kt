package com.marvel.test.usecase.interactors.character

import android.util.Log
import com.marvel.test.base.AppResultHandler
import com.marvel.test.bo.CharacterBO
import com.marvel.test.repository.character.ICharacterRepository
import com.marvel.test.retrofit.commons.ResultHandler
import com.marvel.test.usecase.mappers.toCharacterListBO

class CharacterUseCase(private val characterRepository: ICharacterRepository) : ICharacterUseCase {

    override suspend fun getCharacters(nextPage: Int): AppResultHandler<List<CharacterBO>> {
        return when (val characterResponse = characterRepository.getCharacters(nextPage)) {
            is ResultHandler.Success -> {
                AppResultHandler.Success(characterResponse.data.toCharacterListBO())
            }
            else -> {
                AppResultHandler.GenericError()
            }
        }
    }
}