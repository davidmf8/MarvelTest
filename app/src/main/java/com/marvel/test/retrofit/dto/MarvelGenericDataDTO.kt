package com.marvel.test.retrofit.dto


import com.google.gson.annotations.SerializedName

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