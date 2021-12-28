package com.marvel.test.retrofit.dto

import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName

@Keep
data class UrlDTO(
    @SerializedName("type")
    val type: String?,
    @SerializedName("url")
    val url: String?
)