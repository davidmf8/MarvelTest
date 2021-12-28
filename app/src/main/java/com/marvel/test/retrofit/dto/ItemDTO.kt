package com.marvel.test.retrofit.dto

import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName

@Keep
data class ItemDTO(
    @SerializedName("name")
    val name: String?,
    @SerializedName("resourceURI")
    val resourceURI: String?
)