package com.marvel.test.ui.characterDetail

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.marvel.test.R
import com.marvel.test.base.BaseFragment
import com.marvel.test.bo.CharacterDetailBO
import com.marvel.test.databinding.FragmentCharacterDetailBinding
import com.marvel.test.extension.configRecyclerViewAsGrid
import com.marvel.test.extension.loadRemoteImage
import com.marvel.test.extension.openInternalUrl
import com.marvel.test.extension.recyclerViewSlideFromRightAnimation

class CharacterDetailFragment: BaseFragment() {
    companion object {
        private const val ARG_CHARACTER_DETAIL = "arg_character_detail"

        fun newInstance(characterDetailBO: CharacterDetailBO) =  CharacterDetailFragment().apply {
            arguments = Bundle().apply {
                putSerializable(ARG_CHARACTER_DETAIL, characterDetailBO)
            }
        }
    }

    private lateinit var characterDetailBO: CharacterDetailBO
    private lateinit var binding: FragmentCharacterDetailBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCharacterDetailBinding.inflate(
            inflater, container, false
        )
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.getSerializable(ARG_CHARACTER_DETAIL)?.let {
            characterDetailBO = it as CharacterDetailBO
        }

       configView()
    }

    private fun configView() {
        binding.ivCharacterImage.loadRemoteImage(characterDetailBO.imageUrl)
        binding.tvCharacterName.text = characterDetailBO.name
        binding.tvCharacterDescription.text = characterDetailBO.description
        if(characterDetailBO.detailUrl.isNotEmpty()) {
            binding.cvCharacterDetailUrl.visibility = View.VISIBLE
            binding.cvCharacterDetailUrl.setOnClickListener {
                requireActivity().openInternalUrl(characterDetailBO.detailUrl)
            }
        } else {
            binding.cvCharacterDetailUrl.visibility = View.GONE
        }

        binding.rvComics.adapter = ComicAdapter(characterDetailBO.comicsList)
        configRecyclerViewAsGrid(binding.rvComics, 3)
        binding.rvComics.recyclerViewSlideFromRightAnimation(requireContext())
    }

    override fun getViewName(): String = getString(R.string.character_detail_screen_view)
}