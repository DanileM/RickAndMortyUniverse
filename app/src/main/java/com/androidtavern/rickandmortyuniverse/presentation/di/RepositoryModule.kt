package com.androidtavern.rickandmortyuniverse.presentation.di

import com.androidtavern.rickandmortyuniverse.data.repository.CharacterRepositoryImpl
import com.androidtavern.rickandmortyuniverse.domain.repository.CharacterRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun bindCharacterRepository(
        repository: CharacterRepositoryImpl
    ): CharacterRepository
}