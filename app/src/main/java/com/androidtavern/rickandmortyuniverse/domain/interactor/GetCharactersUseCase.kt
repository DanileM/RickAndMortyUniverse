package com.androidtavern.rickandmortyuniverse.domain.interactor

import androidx.paging.PagingData
import androidx.paging.map
import com.androidtavern.rickandmortyuniverse.data.model.CharacterResponse
import com.androidtavern.rickandmortyuniverse.domain.mapper.base.Mapper
import com.androidtavern.rickandmortyuniverse.domain.model.Character
import com.androidtavern.rickandmortyuniverse.domain.repository.CharacterRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class GetCharactersUseCase @Inject constructor(
    private val repository: CharacterRepository,
    private val mapper: Mapper<CharacterResponse, Character>
) {

    fun invoke(): Flow<PagingData<Character>> =
        repository.getCharacters().map { pagingData ->
            pagingData.map { characterResponse ->
                mapper.map(characterResponse)
            }
        }
}