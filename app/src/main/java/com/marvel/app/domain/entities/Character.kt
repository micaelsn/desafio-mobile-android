package com.marvel.app.domain.entities
import java.io.Serializable


data class Character(
    val id: Int,
    val name: String,
    val description: String,
    val thumbnail: Thumbnail):Serializable