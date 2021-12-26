package com.marvel.test.retrofit.commons

import retrofit2.HttpException
import retrofit2.Response
import java.io.IOException

/**
 * Base Class for use on all remote repository
 */

open class BaseApi {

    suspend fun <T : Any> request(call: suspend () -> Response<T>): ResultHandler<T> {

        return try {
            val response = call.invoke()
            if (response.isSuccessful)
                if (response.body() == null) {
                    ResultHandler.SuccessEmpty
                } else
                    ResultHandler.Success(response.body()!!)
            else {
                ResultHandler.HttpError(response.code(), response.message())
            }
        } catch (throwable: Throwable) {
            when (throwable) {
                is IOException -> ResultHandler.NetworkError
                is HttpException -> {
                    ResultHandler.HttpError(throwable.code(), throwable.message())
                }
                else -> {
                    ResultHandler.GenericError(throwable.message)
                }
            }
        }
    }
}
