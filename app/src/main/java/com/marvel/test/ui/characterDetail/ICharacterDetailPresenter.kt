package com.marvel.test.ui.characterDetail

import androidx.lifecycle.MutableLiveData
import com.marvel.test.base.IBasePresenter
import com.marvel.test.bo.CharacterBO
import com.marvel.test.bo.CharacterDetailBO

interface ICharacterDetailPresenter: IBasePresenter {
    fun loadCharacterData(id: Int)
    fun getCharacterLiveData(): MutableLiveData<CharacterDetailBO>
    fun showLoadErrorLiveData(): MutableLiveData<Boolean>
    fun showProgressLiveData(): MutableLiveData<Boolean>
}