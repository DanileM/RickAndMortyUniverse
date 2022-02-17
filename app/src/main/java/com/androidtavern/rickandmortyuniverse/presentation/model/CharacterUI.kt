package com.androidtavern.rickandmortyuniverse.presentation.model

import android.content.Context

data class CharacterUI(
    val id: Int,
    val name: String,
    val status: CharacterStatusUI,
    val species: String,
    val type: String,
    val gender: String,
    val origin: OriginUI,
    val image: String,
    val url: String,
    val location: LocationUI,
    val episode: List<String>
) {

    fun getCharacterStatus(context: Context) = "${context.getString(status.naming)} - $species"

    fun getStatusColor() = status.color

    fun getCharacterFrom() = origin.name
}

data class OriginUI(
    val name: String,
    val url: String
)

data class LocationUI(
    val name: String,
    val url: String
)
