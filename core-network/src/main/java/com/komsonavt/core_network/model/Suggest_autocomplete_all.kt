package com.komsonavt.core_network.model

import com.google.gson.annotations.SerializedName

data class Suggest_autocomplete_all (

	@SerializedName("input") val input : List<String>,
	@SerializedName("contexts") val contexts : Contexts
)