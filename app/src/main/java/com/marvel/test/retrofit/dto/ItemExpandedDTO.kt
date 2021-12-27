package com.marvel.test.retrofit.dto


import com.google.gson.annotations.SerializedName

data class ItemExpandedDTO(
    @SerializedName("name")
    val name: String?,
    @SerializedName("resourceURI")
    val resourceURI: String?,
    @SerializedName("type")
    val type: String?
)