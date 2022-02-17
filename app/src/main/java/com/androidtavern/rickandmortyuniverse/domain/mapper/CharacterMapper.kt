package com.androidtavern.rickandmortyuniverse.domain.mapper

import com.androidtavern.rickandmortyuniverse.data.model.CharacterResponse
import com.androidtavern.rickandmortyuniverse.domain.mapper.base.Mapper
import com.androidtavern.rickandmortyuniverse.domain.model.Character
import com.androidtavern.rickandmortyuniverse.domain.model.Location
import com.androidtavern.rickandmortyuniverse.domain.model.Origin
import com.androidtavern.rickandmortyuniverse.domain.model.getCharacterStatusEnum
import javax.inject.Inject

class CharacterMapper @Inject constructor(): Mapper<CharacterResponse, Character>() {
    override fun map(from: CharacterResponse) = from.run {
        Character(
            id = id,
            name = name,
            status = getCharacterStatusEnum(status),
            species = species,
            type = type,
            gender = gender,
            origin = Origin(
                origin.name,
                origin.url
            ),
            image = image,
            url = url,
            location = Location(
                name = name,
                url = url
            ),
            episode = episode
        )
    }
}