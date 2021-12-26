package com.marvel.test.base

import androidx.lifecycle.LifecycleOwner

interface IBasePresenter {
    fun removeObservers(lifecycleOwner: LifecycleOwner)
}
