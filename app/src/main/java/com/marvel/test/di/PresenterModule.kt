package com.marvel.test.di

import com.marvel.test.base.analitycs.AnalyticsPresenter
import com.marvel.test.base.analitycs.IAnalyticsPresenter
import com.marvel.test.ui.characterDetail.CharacterDetailPresenter
import com.marvel.test.ui.characterDetail.ICharacterDetailPresenter
import com.marvel.test.ui.characters.CharactersPresenter
import com.marvel.test.ui.characters.ICharactersPresenter
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.bind
import org.koin.dsl.module

val presenterModule: Module = module {
    viewModel { AnalyticsPresenter(get()) } bind (IAnalyticsPresenter::class)
    viewModel { CharactersPresenter(get()) } bind (ICharactersPresenter::class)
    viewModel { CharacterDetailPresenter(get()) } bind (ICharacterDetailPresenter::class)
}
