package com.marvel.test.usecase.interactors.character

import android.util.Log
import com.marvel.test.base.AppResultHandler
import com.marvel.test.bo.CharacterBO
import com.marvel.test.repository.character.ICharacterRepository
import com.marvel.test.retrofit.commons.ResultHandler
import com.marvel.test.usecase.mappers.toCharacterBO
import com.marvel.test.usecase.mappers.toCharacterListBO

class CharacterUseCase(private val characterRepository: ICharacterRepository) : ICharacterUseCase {

    override suspend fun getCharacters(nextPage: Int): AppResultHandler<List<CharacterBO>> {
        return when (val characterResponse = characterRepository.getCharacters(nextPage)) {
            is ResultHandler.Success -> {
                Log.d("response", characterResponse.toString())
                AppResultHandler.Success(characterResponse.data.toCharacterListBO())
            }
            is ResultHandler.MarvelError -> AppResultHandler.GenericError(characterResponse.marvelErrorDTO.code, characterResponse.marvelErrorDTO.status)
            else -> {
                AppResultHandler.GenericError()
            }
        }
    }

    override suspend fun getCharacterDetail(id: Int): AppResultHandler<CharacterBO> {
        return when (val characterResponse = characterRepository.getCharacterDetail(id)) {
            is ResultHandler.Success -> {
                AppResultHandler.Success(characterResponse.data.toCharacterBO())
            }
            is ResultHandler.MarvelError -> AppResultHandler.GenericError(characterResponse.marvelErrorDTO.code, characterResponse.marvelErrorDTO.status)
            else -> {
                AppResultHandler.GenericError()
            }
        }
    }
}