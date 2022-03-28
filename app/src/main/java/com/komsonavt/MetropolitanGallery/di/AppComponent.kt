package com.komsonavt.MetropolitanGallery.di

import android.content.Context
import com.komsonavt.MetropolitanGallery.util.ResourceProvider
import com.komsonavt.MetropolitanGallery.util.ResourceProviderImp
import dagger.Binds
import dagger.BindsInstance
import dagger.Component
import dagger.Module
import javax.inject.Singleton

@Component(modules = [AppModule::class])
@Singleton
interface AppComponent {

    fun resources() : ResourceProvider

    @Component.Builder
    interface Builder{
        @BindsInstance
        fun appContext(context: Context) : Builder

        fun build() : AppComponent
    }
}

@Module
abstract class AppModule{

    @Binds
    @Singleton
    abstract fun bindResourceProvider(provider: ResourceProviderImp) : ResourceProvider
}