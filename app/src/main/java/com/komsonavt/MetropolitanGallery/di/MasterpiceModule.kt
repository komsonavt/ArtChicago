package com.komsonavt.MetropolitanGallery.di

import androidx.lifecycle.ViewModel
import com.komsonavt.MetropolitanGallery.descriptionMasterpiece.MasterpieceViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class MasterpiceModule {

    @Binds
    @IntoMap
    @ViewModelKey(MasterpieceViewModel::class)
    abstract fun masterpieceViewModel(viewModel: MasterpieceViewModel): ViewModel
}