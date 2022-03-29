package com.komsonavt.MetropolitanGallery.artworks

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.komsonavt.MetropolitanGallery.base.BaseListItem
import com.komsonavt.MetropolitanGallery.base.BaseViewModel
import com.komsonavt.MetropolitanGallery.dataSource.ArtworkRepository
import com.komsonavt.core_network.model.Artwork
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ArtworkViewModel @Inject constructor(
    private val repository: ArtworkRepository
) : BaseViewModel() {

    private val _departmentLiveData = MutableLiveData<List<BaseListItem>>()
    val departmentLiveData: LiveData<List<BaseListItem>> = _departmentLiveData

    init {
        viewModelScope.launch(Dispatchers.IO) {
            _departmentLiveData.postValue(getLoaders())
        }
    }

    fun getItems(): Flow<PagingData<Artwork>> {
        return repository.getArtworksResultStream().cachedIn(viewModelScope)
    }
}