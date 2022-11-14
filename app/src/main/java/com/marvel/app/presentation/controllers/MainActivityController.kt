package com.marvel.app.presentation.controllers

import android.content.ContentProvider
import android.content.Context
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.recyclerview.widget.LinearLayoutManager
import com.marvel.app.data.external.datasources.CharactersDataSource
import com.marvel.app.data.infra.datasources.ICharactersDataSource
import com.marvel.app.data.external.api_retrofit.ApiRetrofit.retrofit
import com.marvel.app.data.infra.repositories.CharactersRepository
import com.marvel.app.domain.repositories.ICharactersRepository
import com.marvel.app.domain.usecases.CharactersUseCase
import com.marvel.app.databinding.FragmentHomeBinding
import com.marvel.app.domain.entities.HomeState
import com.marvel.app.presentation.presenters.adapters.HomeAdapter
import kotlinx.coroutines.*

class MainActivityController {
    private val dataSource: ICharactersDataSource = CharactersDataSource(retrofit)
    private val repository: ICharactersRepository = CharactersRepository(dataSource)
    private val charactersUseCase = CharactersUseCase(repository)

    var homeState = HomeState()

    suspend fun getCarouselCharacters() {
        CoroutineScope(Dispatchers.IO).launch {
            val res = async {
                charactersUseCase.getCharacter()
            }
            val list = res.await()
            withContext(Dispatchers.Main){
                list.let {
                    homeState.charactersCarousel.clear()
                    homeState.charactersCarousel.addAll(list)
                }
            }
        }
    }

    suspend fun getListCharacters() {
        CoroutineScope(Dispatchers.IO).launch {
            val res = async {
                charactersUseCase.getCharacter()
            }
            val list = res.await()
            withContext(Dispatchers.Main){
                list.let {
                    homeState.charactersList.clear()
                    homeState.charactersList.addAll(list)
                }
            }
        }
    }

}