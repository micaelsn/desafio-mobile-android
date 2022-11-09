package com.marvel.app.data.infra.repositories

import com.marvel.app.data.infra.datasources.ICharactersDataSource
import com.marvel.app.domain.repositories.ICharactersRepository
import com.marvel.app.domain.entities.Character

class CharacterRepository(
    private val dataSource: ICharactersDataSource
) : ICharactersRepository {

    override suspend fun getCharacters(): List<Character> {
        val characters = dataSource.getCharacters(5)
        return characters.map{ item-> item.toMap() }
    }

}