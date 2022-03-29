package com.komsonavt.MetropolitanGallery.descriptionMasterpiece

import androidx.lifecycle.viewModelScope
import com.komsonavt.MetropolitanGallery.base.BaseViewModel
import com.komsonavt.MetropolitanGallery.dataSource.MasterpieceSource
import com.komsonavt.core_network.api.GalleryApi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.zip
import kotlinx.coroutines.launch
import javax.inject.Inject

class MasterpieceViewModel @Inject constructor(
    private val masterpieceSource: MasterpieceSource
) : BaseViewModel() {

    private val _masterpieceData = MutableStateFlow(MasterpieceItem())
    val masterpieceData: StateFlow<MasterpieceItem> = _masterpieceData

    init {
        viewModelScope.launch {
            val manifest = masterpieceSource.manifest
            val artwork = masterpieceSource.artwork
            artwork.zip(manifest){
                    artwork, manifest ->  MasterpieceItem(id = artwork.id,
                manifest = manifest, name = artwork.title, image = artwork.image_id,
                startYear = artwork.date_start, endYear =  artwork.date_end,
                yearCreate = artwork.fiscal_year)
            }.collect { _masterpieceData.value = it }
        }
    }
}
