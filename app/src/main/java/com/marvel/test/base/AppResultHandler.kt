package com.marvel.test.base

sealed class AppResultHandler<out T : Any> {
    data class Success<out T : Any>(val data: T) : AppResultHandler<T>()
    data class Error(val code: Int? = null, val message: String? = null) : AppResultHandler<Nothing>()
}
