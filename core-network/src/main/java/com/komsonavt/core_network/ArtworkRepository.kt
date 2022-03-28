package com.komsonavt.core_network

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.komsonavt.core_network.api.GalleryApi
import com.komsonavt.core_network.model.Artwork
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ArtworkRepository @Inject constructor(
    private val api : GalleryApi
) {
    fun getArtworksResultStream() : Flow<PagingData<Artwork>>{
        return Pager(
            config = PagingConfig(enablePlaceholders = false, pageSize = 25),
            pagingSourceFactory = {ArtworksPagingSource(api)}
        ).flow
    }
}