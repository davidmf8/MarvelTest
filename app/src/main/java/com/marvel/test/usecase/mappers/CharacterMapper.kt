package com.marvel.test.usecase.mappers

import com.marvel.test.bo.CharacterBO
import com.marvel.test.bo.CharacterDetailBO
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
        this.id,
        this.name ?: "",
        this.thumbnail?.path + "/portrait_xlarge." + this.thumbnail?.extension,
    )
}

fun CharacterDTO.toCharacterDetailBO(): CharacterDetailBO {
    val comicsList: MutableList<String> = ArrayList()
    var detailUrl = ""

    this.comics?.let {
        it.itemDTOS?.let { items ->
            items.forEach { item ->
                item.name?.let { name ->
                    comicsList.add(name)
                }
            }
        }
    }

    this.urlDTOS?.let {
        it.forEach { url ->
            url.type?.let { type ->
                if( type == "detail"){
                    detailUrl = url.url ?: ""
                }
            }
        }
    }

    return CharacterDetailBO(
        this.name,
        this.description,
        this.thumbnail?.path + "/portrait_xlarge." + this.thumbnail?.extension,
        comicsList,
        detailUrl
    )
}