package com.androidtavern.rickandmortyuniverse.data.network

import com.androidtavern.rickandmortyuniverse.data.model.PageResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface CharacterService {

    @GET("character")
    suspend fun getCharacters(
        @Query("page") page: Int
    ): Response<PageResponse>
}