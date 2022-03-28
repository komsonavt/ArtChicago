package com.komsonavt.MetropolitanGallery.catalog

import com.komsonavt.MetropolitanGallery.base.BaseListItem

data class CatalogItem(
    val id : Int,
    val title: String,
    val image : String,
    val year : String
) : BaseListItem {
    override val itemId = id
}