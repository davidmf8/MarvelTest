package com.marvel.test.ui.characters

import android.os.Bundle
import android.view.View
import com.marvel.test.R
import com.marvel.test.base.BaseActivity
import com.marvel.test.bo.CharacterBO
import com.marvel.test.databinding.ActivityCharactersBinding
import com.marvel.test.extension.configRecyclerViewAsGrid
import com.marvel.test.extension.recyclerViewSlideFromRightAnimation
import org.koin.androidx.viewmodel.ext.android.viewModel

class CharactersActivity: BaseActivity(), CharactersAdapter.CharactersListener {
    private val adapter: CharactersAdapter = CharactersAdapter(this)
    private lateinit var binding: ActivityCharactersBinding
    private val presenter: ICharactersPresenter by viewModel<CharactersPresenter>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCharactersBinding.inflate(layoutInflater)
        setContentView(binding.root)
        loadObservers()
        configView()
        presenter.loadCharactersData()

    }

    override fun getViewName(): String = getString(R.string.characters_screen_view)

    override fun loadObservers() {
        presenter.showProgressLiveData().observe(
            this,
            {
                binding.pbLoading.visibility = if (it) View.VISIBLE else View.GONE
            }
        )

        presenter.showLoadErrorLiveData().observe(
            this,
            {
                if (it) binding.tvEmptyCharacters.visibility = View.VISIBLE
                else binding.tvEmptyCharacters.visibility = View.GONE
            }
        )

        presenter.getCharacterLiveData().observe(
            this,
            {
                drawCharacters(it)
            }
        )
    }

    private fun configView(){
        adapter.setCharacterList(ArrayList())
        binding.rvCharacters.adapter = adapter
        configRecyclerViewAsGrid(binding.rvCharacters, 2)
        binding.rvCharacters.recyclerViewSlideFromRightAnimation(this)
    }

    private fun drawCharacters(characterList: List<CharacterBO>) {
        adapter.setCharacterList(characterList)
    }

    override fun onClickCharacter(character: CharacterBO) {

    }

    override fun loadNextPage() {
        presenter.loadNextPage()
    }

    override fun removeObservers() {
        presenter.removeObservers(this)
    }
}