package com.marvel.test.ui.characterDetail

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import com.marvel.test.R
import com.marvel.test.base.BaseActivity
import com.marvel.test.bo.CharacterBO
import com.marvel.test.databinding.ActivityCharacterDetailBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class CharacterDetailActivity: BaseActivity() {
    companion object{
        private const val ARG_CHARACTER_ID = "arg_character_id"

        fun buildIntent(context: Context, id: Int): Intent{
            val intent = Intent(context, CharacterDetailActivity::class.java)
            intent.putExtra(ARG_CHARACTER_ID, id)
            return intent
        }
    }

    private lateinit var binding: ActivityCharacterDetailBinding
    private val presenter: ICharacterDetailPresenter by viewModel<CharacterDetailPresenter>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCharacterDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        loadObservers()
        presenter.loadCharacterData(intent.getIntExtra(ARG_CHARACTER_ID, 0))

    }

    override fun getViewName(): String = getString(R.string.character_detail_screen_view)

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
                drawCharacter(it)
            }
        )
    }

    private fun drawCharacter(characterBO: CharacterBO) {

    }

    override fun removeObservers() {
        presenter.removeObservers(this)
    }
}