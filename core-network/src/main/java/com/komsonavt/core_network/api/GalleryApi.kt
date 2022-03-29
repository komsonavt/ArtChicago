package com.komsonavt.core_network.api

import androidx.paging.PagingSource
import com.komsonavt.core_network.model.*
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query


interface GalleryApi {
    @GET("/api/v1/artworks")
    suspend fun getArtworks(
        @Query("page") page:Int,
        @Query("limit") limit:Int,
    ): PageResult<Artwork>

    @GET("api/v1/artworks/{id}")
    suspend fun getArtworkById(@Path("id")id : Int) : ImageResult<Artwork>

    @GET("/api/v1/images")
    suspend fun getImageDescription(@Query("imageGuid") guid : String) : ImageResult<Image>

    @GET("/iiif/2/{identifier}/full/843,/0/default.jpg")
    suspend fun getPicture(@Path("identifier") identifier : String) : String

    @GET("api/v1/artworks/{id}/manifest.json")
    suspend fun getManifest(@Path("id") id : Int) : Manifest

//    @GET("/public/collection/v1/search")
//    suspend fun getMasterPieceWithImage(@Query("q"))
}