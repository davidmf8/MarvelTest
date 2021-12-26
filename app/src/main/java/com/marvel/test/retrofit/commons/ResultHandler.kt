package com.marvel.test.retrofit.commons


/**
 * Sealed Class to get all responses and cast with the right Type
 */
sealed class ResultHandler<out T : Any> {
    data class Success<out T : Any>(val data: T) : ResultHandler<T>()
    object SuccessEmpty : ResultHandler<Nothing>()
    data class HttpError(val code: Int? = null, val message: String? = null) : ResultHandler<Nothing>()
    data class GenericError(val message: String? = null): ResultHandler<Nothing>()
    object NetworkError: ResultHandler<Nothing>()
}
