package com.marvel.app.data.external.datasources

import com.marvel.app.data.infra.datasources.ICharactersDataSource
import com.marvel.app.data.infra.models.CharacterModel

open class CharactersDataSource() : ICharactersDataSource {

    override suspend fun getCharacters(limit: Int): List<CharacterModel> {
        return listOf<CharacterModel>()
    }
}