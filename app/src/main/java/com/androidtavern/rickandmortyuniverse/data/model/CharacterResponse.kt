package com.androidtavern.rickandmortyuniverse.data.model

data class CharacterResponse(
    val id: Int,
    val name: String,
    val status: String,
    val species: String,
    val type: String,
    val gender: String,
    val origin: OriginResponse,
    val image: String,
    val url: String,
    val location: LocationResponse,
    val episode: List<String>
)

data class OriginResponse(
    val name: String,
    val url: String
)

data class LocationResponse(
    val name: String,
    val url: String
)