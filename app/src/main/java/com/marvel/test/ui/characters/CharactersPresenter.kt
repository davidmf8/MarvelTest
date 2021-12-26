package com.marvel.test.ui.characters

import android.util.Log
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.marvel.test.base.AppResultHandler
import com.marvel.test.base.IBasePresenter
import com.marvel.test.usecase.interactors.character.ICharacterUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class CharactersPresenter(private val charactersUseCase: ICharacterUseCase): ViewModel(), ICharactersPresenter {
    override fun loadCharactersData(){
        viewModelScope.launch {
            withContext(Dispatchers.IO){
                when(charactersUseCase.getCharacters(1)){
                    is AppResultHandler.Success -> {
                    }

                    else -> {

                    }

                }
            }
        }
    }

    override fun removeObservers(lifecycleOwner: LifecycleOwner) {
        TODO("Not yet implemented")
    }
}