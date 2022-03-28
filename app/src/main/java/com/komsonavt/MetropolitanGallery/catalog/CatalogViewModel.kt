package com.komsonavt.MetropolitanGallery.catalog

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.komsonavt.MetropolitanGallery.base.BaseListItem
import com.komsonavt.MetropolitanGallery.base.BaseViewModel
import com.komsonavt.core_network.api.GalleryApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

class CatalogViewModel @Inject constructor(
    private val api: GalleryApi
) : BaseViewModel() {
    private val _catalogLiveData = MutableLiveData<List<BaseListItem>>()
    val catalogLiveData: LiveData<List<BaseListItem>> = _catalogLiveData

    init {
        viewModelScope.launch(Dispatchers.IO) {
            _catalogLiveData.postValue(getLoaders())
//            _catalogLiveData.postValue(getItems())
        }
    }

//    suspend fun catalogData(departmentId:Int): Flow<CatalogItem> = flow{
//        viewModelScope.launch(Dispatchers.IO) {
//            val masterpieces = async{ api.getAllMasterpieceByDep(departmentId)}
//            val masterpiece = flow<Masterpiece> {
//                for (masterpiece in masterpieces.await().masterpieces)
//                    emit(api.getMasterPiece(masterpiece))
//            }
//            val masterpieceList = masterpiece.map { CatalogItem(
//                id = it.id, title = it.title, image = it.primaryImageSmall, year = it.accessionYear
//            ) }
//        }
//    }

//    private suspend fun getItems() : List<CatalogItem>{
//
//        var catalogItemItems = mutableListOf<CatalogItem>()
//        val  masterpieces = api.getImageDescription(0).masterpieces
//        var i : Int = 0
//        val j = if(masterpieces.size <= 20) masterpieces.size else 20
//        while (i < j){
//            val masterpiece = api.getMasterPiece(masterpieces[i])
//            catalogItemItems.add(CatalogItem(id = masterpieces[i],
//            title = masterpiece.title, image = masterpiece.primaryImage,
//            year = masterpiece.accessionYear))
//            i += 1
//        }
//        return catalogItemItems
//    }
}