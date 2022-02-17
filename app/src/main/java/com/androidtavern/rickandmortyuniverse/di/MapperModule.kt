package com.androidtavern.rickandmortyuniverse.di

import com.androidtavern.rickandmortyuniverse.data.model.CharacterResponse
import com.androidtavern.rickandmortyuniverse.domain.mapper.CharacterMapper
import com.androidtavern.rickandmortyuniverse.domain.mapper.base.Mapper
import com.androidtavern.rickandmortyuniverse.domain.model.Character
import com.androidtavern.rickandmortyuniverse.presentation.mapper.CharacterUIMapper
import com.androidtavern.rickandmortyuniverse.presentation.model.CharacterUI
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class MapperModule {

    @Binds
    abstract fun bindCharacterMapper(
        mapper: CharacterMapper
    ): Mapper<CharacterResponse, Character>

    @Binds
    abstract fun bindCharacterUIMapper(
        mapper: CharacterUIMapper
    ): Mapper<Character, CharacterUI>
}