package com.androidtavern.rickandmortyuniverse.presentation.mapper

import com.androidtavern.rickandmortyuniverse.domain.mapper.base.Mapper
import com.androidtavern.rickandmortyuniverse.domain.model.Character
import com.androidtavern.rickandmortyuniverse.presentation.model.CharacterUI
import com.androidtavern.rickandmortyuniverse.presentation.model.LocationUI
import com.androidtavern.rickandmortyuniverse.presentation.model.OriginUI
import com.androidtavern.rickandmortyuniverse.presentation.model.convertToUI
import javax.inject.Inject

class CharacterUIMapper @Inject constructor(): Mapper<Character, CharacterUI>() {
    override fun map(from: Character) = from.run {
        CharacterUI(
            id = id,
            name = name,
            status = status.convertToUI(),
            species = species,
            type = type,
            gender = gender,
            origin = OriginUI(
                origin.name,
                origin.url
            ),
            image = image,
            url = url,
            location = LocationUI(
                name = name,
                url = url
            ),
            episode = episode
        )
    }
}