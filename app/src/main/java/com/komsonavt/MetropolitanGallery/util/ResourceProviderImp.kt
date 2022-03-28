package com.komsonavt.MetropolitanGallery.util

import android.content.Context
import javax.inject.Inject

class ResourceProviderImp @Inject constructor(
    private val context: Context
) : ResourceProvider {
    override fun string(id: Int): String = context.resources.getString(id)
}