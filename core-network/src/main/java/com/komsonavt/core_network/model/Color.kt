package com.komsonavt.core_network.model

import com.google.gson.annotations.SerializedName

data class Color (

	@SerializedName("h") val h : Int,
	@SerializedName("l") val l : Int,
	@SerializedName("s") val s : Int,
	@SerializedName("percentage") val percentage : Double,
	@SerializedName("population") val population : Int
)