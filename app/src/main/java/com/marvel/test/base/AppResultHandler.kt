package com.marvel.test.base

sealed class AppResultHandler<out T : Any> {
    data class Success<out T : Any>(val data: T) : AppResultHandler<T>()
    object SuccessEmpty : AppResultHandler<Nothing>()
    data class GenericError(val code: Int? = null, val message: String? = null) : AppResultHandler<Nothing>()
    object NetworkError : AppResultHandler<Nothing>()
}
