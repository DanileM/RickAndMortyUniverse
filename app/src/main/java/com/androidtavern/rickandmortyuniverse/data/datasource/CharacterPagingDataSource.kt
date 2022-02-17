package com.androidtavern.rickandmortyuniverse.data.datasource

import android.net.Uri
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.androidtavern.rickandmortyuniverse.data.model.CharacterResponse
import com.androidtavern.rickandmortyuniverse.data.network.CharacterService
import retrofit2.HttpException
import javax.inject.Inject

class CharacterPagingDataSource @Inject constructor(
    private val service: CharacterService,
) : PagingSource<Int, CharacterResponse>() {

    override fun getRefreshKey(state: PagingState<Int, CharacterResponse>): Int? {
        val anchorPosition = state.anchorPosition ?: return null
        val page = state.closestPageToPosition(anchorPosition) ?: return null
        return page.prevKey?.plus(1) ?: page.nextKey?.minus(1)
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, CharacterResponse> {
        return try {
            val pageNumber = params.key ?: 1
            val response = service.getCharacters(pageNumber)

            if (response.isSuccessful) {
                val pageResponse = response.body()
                val data = pageResponse?.results
                val nextPageNumber: Int? = getPage(pageResponse?.info?.next)
                val prevPageNumber: Int? = getPage(pageResponse?.info?.prev)

                LoadResult.Page(
                    data = data.orEmpty(),
                    prevKey = prevPageNumber,
                    nextKey = nextPageNumber
                )
            } else {
                LoadResult.Error(HttpException(response))
            }
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }

    private fun getPage(page: String?): Int? {
        if (page == null) return null

        val uri = Uri.parse(page)
        val pageQuery = uri.getQueryParameter("page")
        return pageQuery?.toInt()
    }
}