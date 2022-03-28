package com.komsonavt.MetropolitanGallery.artworks

import com.komsonavt.MetropolitanGallery.base.BaseListItem

data class ArtworkItem(
    val id : Int,
    val title: String,
    val image_id: String?
): BaseListItem{
    override val itemId = id
}