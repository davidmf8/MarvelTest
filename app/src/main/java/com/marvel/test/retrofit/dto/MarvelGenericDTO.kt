package com.marvel.test.retrofit.dto

import com.google.gson.annotations.SerializedName

data class MarvelGenericDTO<T>(
    @SerializedName("attributionHTML")
    val attributionHTML: String?,
    @SerializedName("attributionText")
    val attributionText: String?,
    @SerializedName("code")
    val code: Int?,
    @SerializedName("copyright")
    val copyright: String?,
    @SerializedName("data")
    val data: MarvelGenericDataDTO<T>?,
    @SerializedName("etag")
    val etag: String?,
    @SerializedName("status")
    val status: String?
){
    fun getCustomData(): List<T>? {
        return if (data?.resultDTOS != null && data.resultDTOS.isNotEmpty()) {
            data.resultDTOS
        } else null
    }
}