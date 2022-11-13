package com.marvel.app.data.external.services

import com.marvel.app.data.infra.models.ResponseBody
import retrofit2.http.GET
import retrofit2.http.Query

interface Services {
    @GET("/v1/public/characters")
    suspend fun getCharacters(
        @Query("limit") limit: Int,
        @Query("apikey") apikey: String,
        @Query("hash") hash: String,
    ): ResponseBody
}