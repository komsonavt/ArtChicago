package com.komsonavt.MetropolitanGallery

import android.app.Application
import com.komsonavt.MetropolitanGallery.di.DaggerAppComponent
import com.komsonavt.core_network.DI.DaggerNetworkComponent

class App: Application() {
    override fun onCreate() {
        super.onCreate()
        initDI()
    }
    private fun initDI(){
        DI.appComponent = DaggerAppComponent.builder()
            .appContext(this).build()

        DI.networkComponent = DaggerNetworkComponent.create()
    }
}