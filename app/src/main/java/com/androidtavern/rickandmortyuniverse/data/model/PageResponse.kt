package com.androidtavern.rickandmortyuniverse.data.model

data class PageResponse(
    val info: PageInfoResponse,
    val results: List<CharacterResponse>
)