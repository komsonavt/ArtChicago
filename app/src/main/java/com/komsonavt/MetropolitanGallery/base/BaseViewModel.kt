package com.komsonavt.MetropolitanGallery.base

import androidx.lifecycle.ViewModel

abstract class BaseViewModel : ViewModel() {

    protected fun getLoaders(): List<BaseListItem> {

        return IntRange(1,8).map { ProgressShimmerItem }
    }
}