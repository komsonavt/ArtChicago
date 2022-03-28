package com.komsonavt.MetropolitanGallery.artworks

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.komsonavt.MetropolitanGallery.base.BaseListItem
import com.komsonavt.MetropolitanGallery.base.BaseViewModel
import com.komsonavt.MetropolitanGallery.util.ResourceProvider
import com.komsonavt.core_network.api.GalleryApi
import kotlinx.coroutines.*
import javax.inject.Inject

class ArtworkViewModel @Inject constructor(
private val resourceProvider: ResourceProvider,
private val api : GalleryApi
) : BaseViewModel() {

    private val _departmentLiveData = MutableLiveData<List<BaseListItem>>()
    val departmentLiveData: LiveData<List<BaseListItem>> = _departmentLiveData

    init {
        viewModelScope.launch(Dispatchers.IO) {
            _departmentLiveData.postValue(getLoaders())
            _departmentLiveData.postValue(getItems())
        }
    }

    private suspend fun getItems() : List<ArtworkItem>{

        var departmentItems = mutableListOf<ArtworkItem>()
        val artworks = api.getArtworks()
        for (artwork in api.getArtworks().data){
            departmentItems.add(ArtworkItem(
                id = artwork.id!!, title = artwork.title!!,
                image_id = artwork.image_id
            ))
        }
        return departmentItems
    }
}