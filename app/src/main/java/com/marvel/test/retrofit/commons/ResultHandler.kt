package com.marvel.test.retrofit.commons

import com.marvel.test.retrofit.dto.MarvelErrorDTO

sealed class ResultHandler<out T : Any> {
    data class Success<out T : Any>(val data: T) : ResultHandler<T>()
    object SuccessEmpty : ResultHandler<Nothing>()
    data class MarvelError(val marvelErrorDTO: MarvelErrorDTO): ResultHandler<Nothing>()
    data class HttpError(val code: Int? = null, val message: String? = null) : ResultHandler<Nothing>()
    data class GenericError(val message: String? = null): ResultHandler<Nothing>()
    object NetworkError: ResultHandler<Nothing>()
}
