package com.androidtavern.rickandmortyuniverse.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import com.androidtavern.rickandmortyuniverse.data.datasource.CharacterPagingDataSource
import com.androidtavern.rickandmortyuniverse.domain.repository.CharacterRepository
import javax.inject.Inject

class CharacterRepositoryImpl @Inject constructor(
    private val dataSource: CharacterPagingDataSource,
): CharacterRepository {

    override fun getCharacters() = Pager(PagingConfig(pageSize = 5)) { dataSource }.flow
}