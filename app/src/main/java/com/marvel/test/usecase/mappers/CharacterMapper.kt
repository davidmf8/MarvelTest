package com.marvel.test.usecase.mappers

import com.marvel.test.bo.CharacterBO
import com.marvel.test.retrofit.dto.CharactersDTO
import com.marvel.test.retrofit.dto.ResultDTO

fun CharactersDTO.toCharacterListBO(): List<CharacterBO> {
    val list: ArrayList<CharacterBO> = ArrayList()
    this.data?.resultDTOS?.forEach {
        list.add(it.toCharacterBO())
    }
    return list
}

fun ResultDTO.toCharacterBO(): CharacterBO {
    return CharacterBO(
        this.name,
        this.description,
        this.thumbnail?.path,
        this.thumbnail?.extension
    )
}