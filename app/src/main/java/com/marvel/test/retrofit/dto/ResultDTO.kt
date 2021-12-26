package com.marvel.test.retrofit.dto


import com.google.gson.annotations.SerializedName

data class ResultDTO(
    @SerializedName("comics")
    val comics: ComicDTO,
    @SerializedName("description")
    val description: String,
    @SerializedName("events")
    val eventsDTO: EventsDTO,
    @SerializedName("id")
    val id: Int,
    @SerializedName("modified")
    val modified: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("resourceURI")
    val resourceURI: String,
    @SerializedName("series")
    val seriesDTO: SeriesDTO,
    @SerializedName("stories")
    val storiesDTO: StoriesDTO,
    @SerializedName("thumbnail")
    val thumbnail: ThumbnailDTO,
    @SerializedName("urls")
    val urlDTOS: List<UrlDTO>
)