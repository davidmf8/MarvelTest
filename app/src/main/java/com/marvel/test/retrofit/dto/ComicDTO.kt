package com.marvel.test.retrofit.dto


import com.google.gson.annotations.SerializedName

data class ComicDTO(
    @SerializedName("available")
    val available: Int?,
    @SerializedName("collectionURI")
    val collectionURI: String?,
    @SerializedName("items")
    val itemDTOS: List<ItemDTO>?,
    @SerializedName("returned")
    val returned: Int?
)