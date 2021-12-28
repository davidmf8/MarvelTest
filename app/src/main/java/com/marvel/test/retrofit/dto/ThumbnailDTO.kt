package com.marvel.test.retrofit.dto

import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName

@Keep
data class ThumbnailDTO(
    @SerializedName("extension")
    val extension: String?,
    @SerializedName("path")
    val path: String?
)