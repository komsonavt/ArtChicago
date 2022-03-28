package com.komsonavt.core_network.DI

import android.net.Network
import android.os.Build
import com.komsonavt.core_network.BuildConfig
import com.komsonavt.core_network.api.GalleryApi
import dagger.Component
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Singleton
@Component(modules = [NetworkModule::class])
interface NetworkComponent {

    fun api(): GalleryApi
}

@Module
abstract class NetworkModule{

    companion object{

        private const val BASE_URL = "https://api.artic.edu"
        @Provides
        @Singleton
        fun provideApi() : GalleryApi =
            Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(
                    OkHttpClient.Builder().
                    addInterceptor(HttpLoggingInterceptor().apply {
                        level =
                            if(BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY
                            else HttpLoggingInterceptor.Level.NONE
                    }).
                    build()
                )
                .build()
                .create(GalleryApi::class.java)

    }
}