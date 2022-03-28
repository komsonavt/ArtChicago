package com.komsonavt.core_network.model

import com.google.gson.annotations.SerializedName

data class Thumbnail (

	@SerializedName("lqip") val lqip : String,
	@SerializedName("width") val width : Int,
	@SerializedName("height") val height : Int,
	@SerializedName("alt_text") val alt_text : String
)