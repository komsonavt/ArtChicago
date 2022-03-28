package com.komsonavt.core_network.model

import com.google.gson.annotations.SerializedName

data class Contexts (

	@SerializedName("groupings") val groupings : List<String>
)