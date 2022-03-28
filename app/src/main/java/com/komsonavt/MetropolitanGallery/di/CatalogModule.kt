package com.komsonavt.MetropolitanGallery.di

import androidx.lifecycle.ViewModel
import com.komsonavt.MetropolitanGallery.catalog.CatalogViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class CatalogModule {

    @Binds
    @IntoMap
    @ViewModelKey(CatalogViewModel::class)
    abstract fun catalogViewModel(viewModel: CatalogViewModel): ViewModel
}