package com.komsonavt.core_network.model

import com.google.gson.annotations.SerializedName

data class Config (

	@SerializedName("iiif_url") val iiif_url : String,
	@SerializedName("website_url") val website_url : String
)