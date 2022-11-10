package com.marvel.app.data.infra.models

import java.io.Serializable
import com.google.gson.annotations.SerializedName
import com.marvel.app.domain.entities.*

data class CharacterModel(
    @SerializedName("id") val id: Int,
    @SerializedName("name") val name: String,
    @SerializedName("description") val description: String,
    @SerializedName("thumbnail") val thumbnail: Thumbnail,
) : Serializable {
    fun toMap(): Character = Character(
        id = this.id,
        name = this.name,
        description = this.description,
        thumbnail = this.thumbnail,
    )
}