package com.marvel.test.retrofit.dto

import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName

@Keep
data class MarvelErrorDTO(
    @SerializedName("code")
    val code: Int?,
    @SerializedName("status")
    val status: String?
)
