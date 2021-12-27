package com.marvel.test.bo

data class CharacterDetailBO(
    val name: String?,
    val description: String?,
    val imageUrl: String?,
    val comicsList: List<String>,
    val detailUrl: String
)
