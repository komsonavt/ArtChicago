package com.komsonavt.MetropolitanGallery.dataSource

import com.komsonavt.core_network.api.GalleryApi
import com.komsonavt.core_network.model.Artwork
import com.komsonavt.core_network.model.Image
import com.komsonavt.core_network.model.Manifest
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class MasterpieceSource @Inject constructor(
    private val api: GalleryApi,
    private val artworkId: Int,
//    private val imageGuid: String
) {
    val manifest : Flow<Manifest> = flow{
        val manifest = api.getManifest(artworkId)
        emit(manifest)
    }

    val artwork : Flow<Artwork> = flow {
        val artwork = api.getArtworkById(artworkId).data
        emit(artwork)
    }

//    val fullImage : Flow<Image> = flow{
//        val fullImage = api.getImageDescription(imageGuid)
//        emit(fullImage.data)
//    }
}