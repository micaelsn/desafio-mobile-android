package com.marvel.app.presentation.presenters.adapters

import androidx.recyclerview.widget.RecyclerView
import android.view.ViewGroup
import android.view.LayoutInflater
import com.marvel.app.domain.entities.Character
import com.marvel.app.databinding.CardCharacterBinding

class CharactersAdapter(private val characters: List<Character>) :
    RecyclerView.Adapter<CharactersAdapter.ViewHolder>() {

    private var onClickItemListener: ((Character) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            CardCharacterBinding.inflate(
                LayoutInflater.from(parent.context),
                parent, false
            )
        return ViewHolder(binding)
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val character = characters[position]
        holder.binding.textName.text = character.name

        val baseUrl = character.thumbnail.let {
            "${it.path}/portrait_incredible.${it.extension}"
        }
        holder.binding.imageView.loadImage(baseUrl)

        holder.itemView.setOnClickListener {
            onClickItemListener?.invoke(character)
        }
    }

    override fun getItemCount() = characters.size

    inner class ViewHolder(val binding: CardCharacterBinding) :
        RecyclerView.ViewHolder(binding.root)

}