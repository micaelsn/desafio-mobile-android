package com.marvel.app.presentation.presenters.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.marvel.app.domain.entities.HomeState
import com.marvel.app.databinding.FragmentListBinding
import com.marvel.app.databinding.FragmentCarouselBinding

class HomeAdapter(private val homeState: HomeState) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {


    override fun getItemViewType(position: Int): Int = position

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        val viewHolder: RecyclerView.ViewHolder = if (viewType == 0) {
            val binding = FragmentCarouselBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
            ViewHolderCarousel(binding)
        } else {
            val binding = FragmentListBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
            ViewHolderList(binding)
        }
        return viewHolder
    }

    override fun getItemCount(): Int = 2

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (position == 0) {
            holder as ViewHolderCarousel
            holder.recyclerCarousel.apply {
                layoutManager = LinearLayoutManager(
                    holder.itemView.context,
                    LinearLayoutManager.HORIZONTAL, false
                )
                setHasFixedSize(true)
                adapter = homeState.charactersCarousel?.let { characters -> CharactersAdapter(characters) }
            }
        } else {
            holder as ViewHolderList
            holder.recyclerList.apply {
                layoutManager = LinearLayoutManager(
                    holder.itemView.context,
                    LinearLayoutManager.VERTICAL, false
                )
                setHasFixedSize(true)
                adapter = homeState.charactersList?.let { character -> CharactersAdapter(character) }
            }
        }
    }


    inner class ViewHolderList(binding: FragmentListBinding) :
        RecyclerView.ViewHolder(binding.root) {
        val recyclerList: RecyclerView = binding.recyclerList
    }

    inner class ViewHolderCarousel(binding: FragmentCarouselBinding) :
        RecyclerView.ViewHolder(binding.root) {
        val recyclerCarousel: RecyclerView = binding.recyclerCarousel
    }

}