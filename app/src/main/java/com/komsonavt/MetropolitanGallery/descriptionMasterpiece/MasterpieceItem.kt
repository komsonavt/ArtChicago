package com.komsonavt.MetropolitanGallery.descriptionMasterpiece

import com.komsonavt.core_network.model.Manifest

data class MasterpieceItem(
    val id : Int? = null,
    val name : String? = null,
    var startYear : String? = null,
    var endYear : String? = null,
    var yearCreate : String? = null,
    var manifest: Manifest? = null,
    var image : String? = null
)
