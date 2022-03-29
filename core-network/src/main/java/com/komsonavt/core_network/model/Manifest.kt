package com.komsonavt.core_network.model

import com.google.gson.annotations.SerializedName

data class Manifest(
    @SerializedName ("label") val label: String,
    @SerializedName("description") val description : List<ManifestData>
)

data class ManifestData(
    @SerializedName("value") val string: String
)