package com.marvel.test.ui.characters

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.marvel.test.base.AppResultHandler
import com.marvel.test.bo.CharacterBO
import com.marvel.test.constants.RetrofitConstants
import com.marvel.test.constants.RetrofitConstants.CHARACTERS_API_LIMIT
import com.marvel.test.usecase.interactors.character.ICharacterUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class CharactersPresenter(private val charactersUseCase: ICharacterUseCase) : ViewModel(),
    ICharactersPresenter {
    private val charactersLiveData: MutableLiveData<List<CharacterBO>> = MutableLiveData()
    private val showErrorLiveData: MutableLiveData<Boolean> = MutableLiveData()
    private val showProgressLiveData: MutableLiveData<Boolean> = MutableLiveData()

    override fun getCharacterLiveData(): MutableLiveData<List<CharacterBO>> = charactersLiveData
    override fun showLoadErrorLiveData(): MutableLiveData<Boolean> = showErrorLiveData
    override fun showProgressLiveData(): MutableLiveData<Boolean> = showProgressLiveData

    private var page: Int = 1
    private var hasNextPage: Boolean = true
    private val characterList: ArrayList<CharacterBO> = ArrayList()


    override fun loadCharactersData() {
        showProgressLiveData.value = true
        viewModelScope.launch {
            val charactersResponse = withContext(Dispatchers.IO) {
                charactersUseCase.getCharacters(page)
            }
            showProgressLiveData.value = false
            when (charactersResponse) {
                is AppResultHandler.Success -> {
                    characterList.addAll(charactersResponse.data)
                    charactersLiveData.value = characterList
                    if (characterList.size >= CHARACTERS_API_LIMIT) {
                        page += CHARACTERS_API_LIMIT
                        hasNextPage = true
                    } else {
                        hasNextPage = false
                    }
                }

                else -> {
                    if (page > 1) {
                        showErrorLiveData.value = true
                    }
                }
            }
        }
    }

    override fun loadNextPage() {
        if (hasNextPage) {
            loadCharactersData()
        }
    }

    override fun removeObservers(lifecycleOwner: LifecycleOwner) {
        charactersLiveData.removeObservers(lifecycleOwner)
        showErrorLiveData.removeObservers(lifecycleOwner)
        showProgressLiveData.removeObservers(lifecycleOwner)
    }
}