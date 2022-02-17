package com.androidtavern.rickandmortyuniverse.presentation.di

import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    private companion object {
        const val HOST_NAME = "https://rickandmortyapi.com/api/"
        const val DATE_FORMAT = "yyyy-MM-dd'T'hh:mm:ssXXX"
    }

    @Provides
    fun provideGsonBuilder(): GsonBuilder =
        GsonBuilder()
            .serializeNulls()
            .setPrettyPrinting()
            .setDateFormat(DATE_FORMAT)

    @Provides
    fun provideRetrofit(gsonBuilder: GsonBuilder): Retrofit =
        Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create(gsonBuilder.create()))
            .baseUrl(HOST_NAME)
            .build()
}