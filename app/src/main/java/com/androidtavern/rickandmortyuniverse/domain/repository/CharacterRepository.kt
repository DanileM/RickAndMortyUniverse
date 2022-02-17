package com.androidtavern.rickandmortyuniverse.domain.repository

import androidx.paging.PagingData
import com.androidtavern.rickandmortyuniverse.data.model.CharacterResponse
import com.androidtavern.rickandmortyuniverse.domain.model.Character
import kotlinx.coroutines.flow.Flow

interface CharacterRepository {
    fun getCharacters(): Flow<PagingData<CharacterResponse>>
}