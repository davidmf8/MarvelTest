package com.marvel.test.retrofit.dto

import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName

@Keep
data class ItemExpandedDTO(
    @SerializedName("name")
    val name: String?,
    @SerializedName("resourceURI")
    val resourceURI: String?,
    @SerializedName("type")
    val type: String?
)