package com.marvel.test.ui.characters

import androidx.lifecycle.MutableLiveData
import com.marvel.test.base.IBasePresenter
import com.marvel.test.bo.CharacterBO

interface ICharactersPresenter: IBasePresenter {
    fun loadCharactersData()
    fun getCharacterLiveData(): MutableLiveData<List<CharacterBO>>
    fun showLoadErrorLiveData(): MutableLiveData<Boolean>
    fun showProgressLiveData(): MutableLiveData<Boolean>
    fun loadNextPage()
}