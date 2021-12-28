package com.marvel.test.retrofit.dto

import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName

@Keep
data class StoriesDTO(
    @SerializedName("available")
    val available: Int?,
    @SerializedName("collectionURI")
    val collectionURI: String?,
    @SerializedName("items")
    val items: List<ItemExpandedDTO>?,
    @SerializedName("returned")
    val returned: Int?
)