package com.marvel.test.ui.characterDetail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.marvel.test.R
import com.marvel.test.base.BaseFragment
import com.marvel.test.databinding.FragmentCharacterDetailErrorBinding

class CharacterDetailErrorFragment: BaseFragment() {
    companion object {
        fun newInstance() = CharacterDetailErrorFragment()
    }

    private lateinit var binding: FragmentCharacterDetailErrorBinding


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCharacterDetailErrorBinding.inflate(
            inflater, container, false
        )
        return binding.root
    }

    override fun getViewName(): String = getString(R.string.character_detail_error_screen_view)
}