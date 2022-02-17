package com.androidtavern.rickandmortyuniverse.domain.model

data class Character(
    val id: Int,
    val name: String,
    val status: CharacterStatus,
    val species: String,
    val type: String,
    val gender: String,
    val origin: Origin,
    val image: String,
    val url: String,
    val location: Location,
    val episode: List<String>
)

data class Origin(
    val name: String,
    val url: String
)

data class Location(
    val name: String,
    val url: String
)