package com.marvel.test.di

import com.marvel.test.usecase.interactors.analytics.AnalyticsUseCase
import com.marvel.test.usecase.interactors.analytics.IAnalyticsUseCase
import com.marvel.test.usecase.interactors.character.CharacterUseCase
import com.marvel.test.usecase.interactors.character.ICharacterUseCase
import org.koin.core.module.Module
import org.koin.dsl.module

val useCaseModule: Module = module {
    single<IAnalyticsUseCase> { AnalyticsUseCase(get()) }
    single<ICharacterUseCase> { CharacterUseCase(get()) }
}
