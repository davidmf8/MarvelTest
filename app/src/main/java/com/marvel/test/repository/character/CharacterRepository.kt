package com.marvel.test.repository.character

import com.marvel.test.retrofit.commons.ResultHandler
import com.marvel.test.retrofit.dto.CharacterDTO
import com.marvel.test.retrofit.dto.MarvelGenericDTO
import com.marvel.test.retrofit.implementation.CharacterApi

class CharacterRepository(private val api: CharacterApi): ICharacterRepository {
    override suspend fun getCharacters(offset: Int): ResultHandler<List<CharacterDTO>> {
        return api.getCharacters(offset).sendResponse()
    }

    override suspend fun getCharacterDetail(id: Int): ResultHandler<CharacterDTO> {
        return when(val response = api.getCharacterDetail(id).sendResponse()){
            is ResultHandler.Success -> {
                ResultHandler.Success(response.data[0])
            }

            is ResultHandler.MarvelError -> {
                return response
            }
            is ResultHandler.HttpError -> {
                return response
            }
            else ->{
                return ResultHandler.GenericError()
            }
        }
    }

    private fun <K: Any, T: MarvelGenericDTO<K>> ResultHandler<T>.sendResponse(): ResultHandler<ArrayList<K>> {
        when (this) {
            is ResultHandler.Success -> {
                this.data.data?.resultDTOS?.let {
                    return ResultHandler.Success(ArrayList(it))
                }.run{
                    return ResultHandler.GenericError()
                }
            }
            is ResultHandler.MarvelError -> {
                return this
            }
            is ResultHandler.HttpError -> {
                return this
            }
            else ->{
                return ResultHandler.GenericError()
            }
        }
    }
}