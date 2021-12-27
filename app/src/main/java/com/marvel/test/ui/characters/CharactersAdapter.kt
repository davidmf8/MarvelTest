package com.marvel.test.ui.characters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.marvel.test.bo.CharacterBO
import com.marvel.test.databinding.RowCharacterBinding

class CharactersAdapter(private val listener: CharactersListener) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    interface CharactersListener {
        fun onClickCharacter(character: CharacterBO)
        fun loadNextPage()
    }

    private lateinit var characterList: List<CharacterBO>
    private lateinit var binding: RowCharacterBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        binding = RowCharacterBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return CharacterViewHolder(
            binding
        )
    }

    override fun getItemCount(): Int {
        return characterList.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as CharacterViewHolder).bind(
            characterList[position]
        )

        if (position >= itemCount - 1) {
            listener.loadNextPage()
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setCharacterList(characterList: List<CharacterBO>) {
        this.characterList = characterList
        notifyDataSetChanged()
    }

    inner class CharacterViewHolder(private val itemBinding: RowCharacterBinding) :
        RecyclerView.ViewHolder(itemBinding.root) {

        fun bind(characterBO: CharacterBO) {
            itemBinding.tvCharacterName.text = characterBO.name

            Glide
                .with(itemBinding.ivCharacterImage.context)
                .load(characterBO.imageUrl)
                .into(itemBinding.ivCharacterImage)

            itemView.setOnClickListener {
                listener.onClickCharacter(
                    characterBO
                )
            }
        }
    }
}