package com.marvel.app.data.infra.models

data class Data( val offset: String?,
                        val limit: Int?,
                        val total: Int?,
                        val count: Int?,
                        val results: List<CharacterModel>?)