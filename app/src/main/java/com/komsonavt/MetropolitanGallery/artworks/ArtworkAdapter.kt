package com.komsonavt.MetropolitanGallery.artworks

import com.hannesdorfmann.adapterdelegates4.AsyncListDifferDelegationAdapter
import com.komsonavt.MetropolitanGallery.base.AdapterDelegates
import com.komsonavt.MetropolitanGallery.base.BaseDiffUtilItemCallback
import com.komsonavt.MetropolitanGallery.base.BaseListItem

class ArtworkAdapter : AsyncListDifferDelegationAdapter<BaseListItem>(BaseDiffUtilItemCallback()) {
    init {
        delegatesManager.addDelegate(
            AdapterDelegates.departmentDelegate())
            .addDelegate(AdapterDelegates.loadShimmerDelegate)
    }
}
