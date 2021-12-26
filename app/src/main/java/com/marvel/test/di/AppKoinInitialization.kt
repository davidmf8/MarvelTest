package com.marvel.test.di


import org.koin.core.module.Module

object AppKoinInitialization {
    fun getModules(): List<Module> {
        val modules = mutableListOf<Module>()
        modules.addAll(
            listOf(
                appModule,
                firebaseModule,
                presenterModule,
                useCaseModule,
                repositoryModule
            )
        )
        return modules
    }
}
