package com.marvel.app.domain.repositories
import com.marvel.app.domain.entities.Character

interface ICharactersRepository {
    suspend fun getCharacters(limit: Int): List<Character>
}