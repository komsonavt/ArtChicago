package com.komsonavt.MetropolitanGallery.di

import com.komsonavt.MetropolitanGallery.DI
import com.komsonavt.MetropolitanGallery.base.ViewModelFactory
import com.komsonavt.MetropolitanGallery.util.ResourceProvider
import com.komsonavt.core_network.api.GalleryApi
import com.komsonavt.core_network.model.Artwork
import dagger.BindsInstance
import dagger.Component
import dagger.Module
import javax.inject.Scope


@MasterpieceScope
@Component(modules = [MasterpiceModule::class])
interface MasterpieceComponent {

    fun viewModelFactory(): ViewModelFactory

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun resources(resourceProvider: ResourceProvider): Builder

        @BindsInstance
        fun api(api: GalleryApi): Builder

        @BindsInstance
        fun artworkId(artworkId: Int) : Builder

        @BindsInstance
        fun imageGuid(imageGuid: String) : Builder

        fun build(): MasterpieceComponent
    }

    companion object {
        fun create(artworkId: Int, imageGuid: String) = with(DI.appComponent) {
            DaggerMasterpieceComponent.builder()
                .resources(resources())
                .api(DI.networkComponent.api())
                .imageGuid(imageGuid)
                .artworkId(artworkId)
                .build()
        }
    }
}


@Scope
annotation class MasterpieceScope