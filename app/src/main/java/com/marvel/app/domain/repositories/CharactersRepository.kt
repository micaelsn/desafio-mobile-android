package com.marvel.app.domain.repositories

interface CharactersRepository {
    fun getCharacters(): List<Character>
}