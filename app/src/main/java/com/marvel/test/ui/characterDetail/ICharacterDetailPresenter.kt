package com.marvel.test.ui.characterDetail

import androidx.lifecycle.MutableLiveData
import com.marvel.test.base.IBasePresenter
import com.marvel.test.bo.CharacterBO

interface ICharacterDetailPresenter: IBasePresenter {
    fun loadCharacterData(id: Int)
    fun getCharacterLiveData(): MutableLiveData<CharacterBO>
    fun showLoadErrorLiveData(): MutableLiveData<Boolean>
    fun showProgressLiveData(): MutableLiveData<Boolean>
}