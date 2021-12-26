package com.marvel.test.retrofit.dto


import com.google.gson.annotations.SerializedName

data class ItemDTO(
    @SerializedName("name")
    val name: String,
    @SerializedName("resourceURI")
    val resourceURI: String
)