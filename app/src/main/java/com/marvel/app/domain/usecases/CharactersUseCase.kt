package com.marvel.app.domain.usecases

import com.marvel.app.domain.repositories.ICharactersRepository

class CharactersUseCase(private val repository: ICharactersRepository) {
    suspend fun getCharacter() = repository.getCharacters()
}