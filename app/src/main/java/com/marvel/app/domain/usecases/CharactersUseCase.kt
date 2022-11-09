package com.marvel.app.domain.usecases

import com.marvel.app.domain.repositories.CharactersRepository

class CharactersUseCase(private val repository: CharactersRepository) {
    fun getCharacter() = repository.getCharacters()
}