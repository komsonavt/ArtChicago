package com.komsonavt.MetropolitanGallery.di

import androidx.lifecycle.ViewModel
import com.komsonavt.MetropolitanGallery.artworks.ArtworkViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ArtworkModule{

    @Binds
    @IntoMap
    @ViewModelKey(ArtworkViewModel::class)
    abstract fun artworkViewModel(viewModel: ArtworkViewModel) : ViewModel

}