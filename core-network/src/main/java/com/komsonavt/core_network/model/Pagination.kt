package com.komsonavt.core_network.model

import com.google.gson.annotations.SerializedName

data class Pagination (
	@SerializedName("total") val total : Int,
	@SerializedName("limit") val limit : Int,
	@SerializedName("offset") val offset : Int,
	@SerializedName("total_pages") val total_pages : Int,
	@SerializedName("current_page") val current_page : Int,
	@SerializedName("next_url") val next_url : String
)