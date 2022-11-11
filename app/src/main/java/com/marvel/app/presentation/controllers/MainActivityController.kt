package com.marvel.app.presentation.controllers

import com.marvel.app.data.external.datasources.CharactersDataSource
import com.marvel.app.data.infra.datasources.ICharactersDataSource
import com.marvel.app.data.external.api_retrofit.ApiRetrofit.retrofit
import com.marvel.app.data.infra.repositories.CharactersRepository
import com.marvel.app.domain.repositories.ICharactersRepository
import com.marvel.app.domain.usecases.CharactersUseCase
import com.marvel.app.domain.entities.Character
import kotlinx.coroutines.*

class MainActivityController {
    private val dataSource: ICharactersDataSource = CharactersDataSource(retrofit)
    private val repository: ICharactersRepository = CharactersRepository(dataSource)
    private val charactersUseCase = CharactersUseCase(repository)
    private val charactersCarousel = mutableListOf<Character>()
    private val charactersList = mutableListOf<Character>()

    fun getCarouselCharacters() {
        CoroutineScope(Dispatchers.IO).launch {
            val res = async {
                charactersUseCase.getCharacter()
            }
            val list = res.await()
            withContext(Dispatchers.Main){
                list?.let {
                    charactersCarousel.clear()
                    charactersCarousel.addAll(list)
                }
            }
        }
    }

    fun getListCharacters() {
        CoroutineScope(Dispatchers.IO).launch {
            val res = async {
                charactersUseCase.getCharacter()
            }
            val list = res.await()
            withContext(Dispatchers.Main){
                list?.let {
                    charactersList.clear()
                    charactersList.addAll(list)
                }
            }
        }
    }
}