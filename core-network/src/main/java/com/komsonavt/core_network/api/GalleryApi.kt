package com.komsonavt.core_network.api

import com.komsonavt.core_network.model.*
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface GalleryApi {
    @GET("/api/v1/artworks")
    suspend fun getArtworks(): PageResult<Artwork>

    @GET("/api/v1/artworks/{id}")
    suspend fun getArtworkById(@Path("id")id:Int): Artwork

    @GET("/api/v1/images")
    suspend fun getImageDescription(@Query("imageGuid") guid: String) : ImageResult<Image>

    @GET("/iiif/2/{identifier}/full/843,/0/default.jpg")
    suspend fun getPicture(@Path("identifier") identifier:String)

//    @GET("/public/collection/v1/search")
//    suspend fun getMasterPieceWithImage(@Query("q"))
}