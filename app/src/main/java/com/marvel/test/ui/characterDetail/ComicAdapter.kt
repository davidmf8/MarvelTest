package com.marvel.test.ui.characterDetail

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.marvel.test.databinding.RowCharacterDetailComicBinding

class ComicAdapter(private val comicList: List<String>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {


    private lateinit var binding: RowCharacterDetailComicBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        binding = RowCharacterDetailComicBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return CharacterViewHolder(
            binding
        )
    }

    override fun getItemCount(): Int {
        return comicList.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as CharacterViewHolder).bind(
            comicList[position]
        )
    }

    inner class CharacterViewHolder(private val itemBinding: RowCharacterDetailComicBinding) :
        RecyclerView.ViewHolder(itemBinding.root) {

        fun bind(comic: String) {
            itemBinding.tvComicTitle.text = comic
        }
    }
}