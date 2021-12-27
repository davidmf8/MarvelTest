package com.marvel.test.usecase.mappers

import com.marvel.test.bo.CharacterBO
import com.marvel.test.retrofit.dto.CharacterDTO

fun List<CharacterDTO>.toCharacterListBO(): List<CharacterBO> {
    val list: ArrayList<CharacterBO> = ArrayList()
    this.forEach {
        list.add(it.toCharacterBO())
    }
    return list
}

fun CharacterDTO.toCharacterBO(): CharacterBO {
    return CharacterBO(
        this.name,
        this.description,
        this.thumbnail?.path,
        this.thumbnail?.extension
    )
}