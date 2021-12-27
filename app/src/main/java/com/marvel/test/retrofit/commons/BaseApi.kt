package com.marvel.test.retrofit.commons

import com.google.gson.GsonBuilder
import com.marvel.test.retrofit.dto.MarvelErrorDTO
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
                val marvelError = GsonBuilder().create().fromJson(
                    response.errorBody()?.string(), MarvelErrorDTO::class.java
                )
                ResultHandler.MarvelError(marvelError)
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
