package com.marvel.test.retrofit.dto

import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName

@Keep
data class MarvelGenericDataDTO<T>(
    @SerializedName("count")
    val count: Int?,
    @SerializedName("limit")
    val limit: Int?,
    @SerializedName("offset")
    val offset: Int?,
    @SerializedName("results")
    val resultDTOS: List<T>?,
    @SerializedName("total")
    val total: Int?
)