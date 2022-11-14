package com.marvel.app.data.external.datasources

import com.marvel.app.data.external.services.Services
import com.marvel.app.data.infra.datasources.ICharactersDataSource
import com.marvel.app.data.infra.models.CharacterModel
import retrofit2.Retrofit

open class CharactersDataSource(private val retrofit: Retrofit) : ICharactersDataSource {

    private val charactersServices by lazy { retrofit.create(Services::class.java) }

    override suspend fun getCharacters(limit: Int): List<CharacterModel> {
        val response = charactersServices.getCharacters(limit,
            "7d23b489d3f07e6b0950757f65a9030e",
            "23854d2ddaa7ff0748b4f783c77a17b0844952f7" )
        return response.data.results!!
    }
}