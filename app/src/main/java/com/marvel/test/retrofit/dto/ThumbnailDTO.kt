package com.marvel.test.retrofit.dto


import com.google.gson.annotations.SerializedName

data class ThumbnailDTO(
    @SerializedName("extension")
    val extension: String,
    @SerializedName("path")
    val path: String
)