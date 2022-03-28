package com.komsonavt.MetropolitanGallery.di

import com.komsonavt.MetropolitanGallery.DI
import com.komsonavt.MetropolitanGallery.base.ViewModelFactory
import com.komsonavt.MetropolitanGallery.util.ResourceProvider
import com.komsonavt.core_network.api.GalleryApi
import dagger.BindsInstance
import dagger.Component
import javax.inject.Scope

@DepartmentScope
@Component(modules = [ArtworkModule::class])
interface ArtworkComponent {

    fun viewModelFactory() : ViewModelFactory

    @Component.Builder
    interface Builder{

        @BindsInstance
        fun resources(resourceProvider: ResourceProvider) : Builder

        @BindsInstance
        fun api(api: GalleryApi) : Builder

        fun build():ArtworkComponent
    }

    companion object{
        fun create() = with(DI.appComponent){
            DaggerArtworkComponent.builder()
                .resources(resources())
                .api(DI.networkComponent.api())
                .build()
        }
    }
}


@Scope
annotation class DepartmentScope