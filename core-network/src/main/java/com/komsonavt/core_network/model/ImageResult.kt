package com.komsonavt.core_network.model

import com.google.gson.annotations.SerializedName

data class ImageResult<T>(
    @SerializedName("data")val data : List<T>,
    @SerializedName("info")val info : Info,
    @SerializedName("config") val config : Config
)
