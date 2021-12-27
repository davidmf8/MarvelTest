package com.marvel.test.retrofit.dto


import com.google.gson.annotations.SerializedName

data class DataDTO(
    @SerializedName("count")
    val count: Int?,
    @SerializedName("limit")
    val limit: Int?,
    @SerializedName("offset")
    val offset: Int?,
    @SerializedName("results")
    val resultDTOS: List<ResultDTO>?,
    @SerializedName("total")
    val total: Int?
)