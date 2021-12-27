package com.marvel.test.ui.characterDetail

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.marvel.test.base.AppResultHandler
import com.marvel.test.bo.CharacterBO
import com.marvel.test.constants.RetrofitConstants.CHARACTERS_API_LIMIT
import com.marvel.test.usecase.interactors.character.ICharacterUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class CharacterDetailPresenter(private val charactersUseCase: ICharacterUseCase) : ViewModel(),
    ICharacterDetailPresenter {
    private val characterLiveData: MutableLiveData<CharacterBO> = MutableLiveData()
    private val showErrorLiveData: MutableLiveData<Boolean> = MutableLiveData()
    private val showProgressLiveData: MutableLiveData<Boolean> = MutableLiveData()

    override fun getCharacterLiveData(): MutableLiveData<CharacterBO> = characterLiveData
    override fun showLoadErrorLiveData(): MutableLiveData<Boolean> = showErrorLiveData
    override fun showProgressLiveData(): MutableLiveData<Boolean> = showProgressLiveData

    override fun loadCharacterData(id: Int) {
        showProgressLiveData.value = true
        viewModelScope.launch {
            val charactersResponse = withContext(Dispatchers.IO) {
                charactersUseCase.getCharacterDetail(id)
            }
            showProgressLiveData.value = false
            when (charactersResponse) {
                is AppResultHandler.Success -> {
                    characterLiveData.value = charactersResponse.data
                }

                else -> {
                    showErrorLiveData.value = true
                }
            }
        }
    }

    override fun removeObservers(lifecycleOwner: LifecycleOwner) {
        characterLiveData.removeObservers(lifecycleOwner)
        showErrorLiveData.removeObservers(lifecycleOwner)
        showProgressLiveData.removeObservers(lifecycleOwner)
    }
}