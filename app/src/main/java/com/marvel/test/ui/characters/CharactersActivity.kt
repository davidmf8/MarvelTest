package com.marvel.test.ui.characters

import android.os.Bundle
import com.marvel.test.base.BaseActivity
import com.marvel.test.databinding.ActivityMainBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class CharactersActivity: BaseActivity() {
    private lateinit var binding: ActivityMainBinding
    private val presenter: ICharactersPresenter by viewModel<CharactersPresenter>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        presenter.loadCharactersData()

    }

    override fun getViewName(): String? = null

    override fun loadObservers() {
    }

    override fun removeObservers() {
    }
}