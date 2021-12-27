package com.marvel.test.retrofit.dto

import com.google.gson.annotations.SerializedName

data class MarvelErrorDTO(
    @SerializedName("code")
    val code: Int?,
    @SerializedName("status")
    val status: String?
)
