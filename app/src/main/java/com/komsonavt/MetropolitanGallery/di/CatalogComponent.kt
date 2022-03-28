package com.komsonavt.MetropolitanGallery.di

import com.komsonavt.MetropolitanGallery.DI
import com.komsonavt.MetropolitanGallery.base.ViewModelFactory
import com.komsonavt.MetropolitanGallery.util.ResourceProvider
import com.komsonavt.core_network.api.GalleryApi
import dagger.BindsInstance
import dagger.Component
import javax.inject.Scope

@CatalogScope
@Component(modules = [CatalogModule::class])
interface CatalogComponent {

    fun viewModelFactory(): ViewModelFactory

    @Component.Builder
    interface Builder{

        @BindsInstance
        fun resources(resourceProvider: ResourceProvider) : CatalogComponent.Builder

        @BindsInstance
        fun api(api: GalleryApi) : CatalogComponent.Builder

        fun build():CatalogComponent
    }

    companion object{
        fun create() = with(DI.appComponent){
            DaggerCatalogComponent.builder()
                .resources(resources())
                .api(DI.networkComponent.api())
                .build()
        }
    }
}


@Scope
annotation class CatalogScope