package com.marvel.test.retrofit.dto


import com.google.gson.annotations.SerializedName

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