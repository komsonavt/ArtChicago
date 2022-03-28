package com.komsonavt.core_network.model

import com.google.gson.annotations.SerializedName

data class Info (
	@SerializedName("license_text") val license_text : String,
	@SerializedName("license_links") val license_links : List<String>,
	@SerializedName("version") val version : Double
)