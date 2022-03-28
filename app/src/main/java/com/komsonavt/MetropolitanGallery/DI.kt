package com.komsonavt.MetropolitanGallery

import com.komsonavt.MetropolitanGallery.di.AppComponent
import com.komsonavt.core_network.DI.NetworkComponent

object DI {
    lateinit var appComponent : AppComponent
        internal set

    lateinit var networkComponent: NetworkComponent
        internal set
}