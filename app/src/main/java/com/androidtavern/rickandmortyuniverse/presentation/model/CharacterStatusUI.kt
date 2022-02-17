package com.androidtavern.rickandmortyuniverse.presentation.model

import androidx.annotation.ColorRes
import androidx.annotation.StringRes
import com.androidtavern.rickandmortyuniverse.R
import com.androidtavern.rickandmortyuniverse.domain.model.CharacterStatus

enum class CharacterStatusUI(
    @ColorRes
    val color: Int,
    @StringRes
    val naming: Int
) {
    ALIVE(
        R.color.green,
        R.string.alive
    ),
    DEAD(
        R.color.red,
        R.string.dead
    ),
    UNKNOWN(
        R.color.black,
        R.string.unknown
    )
}

fun CharacterStatus.convertToUI(): CharacterStatusUI {
    return when (this) {
        CharacterStatus.ALIVE -> CharacterStatusUI.ALIVE
        CharacterStatus.DEAD -> CharacterStatusUI.DEAD
        CharacterStatus.UNKNOWN -> CharacterStatusUI.UNKNOWN
    }
}