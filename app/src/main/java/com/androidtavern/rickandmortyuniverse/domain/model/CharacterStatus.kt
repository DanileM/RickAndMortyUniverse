package com.androidtavern.rickandmortyuniverse.domain.model

enum class CharacterStatus {
    ALIVE, DEAD, UNKNOWN
}

fun getCharacterStatusEnum(status: String) =
    when (status) {
        "Alive" -> CharacterStatus.ALIVE
        "Dead" -> CharacterStatus.DEAD
        else -> CharacterStatus.UNKNOWN
    }