package com.marvel.app.data.infra.datasources

import com.marvel.app.data.infra.models.CharacterModel

interface ICharactersDataSource {
    suspend fun getCharacters(limit: Int): List<CharacterModel>
}