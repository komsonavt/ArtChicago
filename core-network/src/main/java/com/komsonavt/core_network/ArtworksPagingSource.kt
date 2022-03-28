package com.komsonavt.core_network

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.komsonavt.core_network.api.GalleryApi
import com.komsonavt.core_network.model.Artwork

class ArtworksPagingSource(
    private val api : GalleryApi
) : PagingSource<Int, Artwork>() {

    private val UNSPLASH_STARTING_PAGE_INDEX = 1

    override fun getRefreshKey(state: PagingState<Int, Artwork>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.prevKey
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Artwork> {
        val page = params.key ?: UNSPLASH_STARTING_PAGE_INDEX
        return try {
            val response = api.getArtworks(page, params.loadSize)
            LoadResult.Page(
                data = response.data,
                prevKey = if (page == UNSPLASH_STARTING_PAGE_INDEX) null else page - 1,
                nextKey = if (page == response.pagination.total) null else page + 1
            )
        } catch (exception: Exception) {
            LoadResult.Error(exception)
        }
    }
}