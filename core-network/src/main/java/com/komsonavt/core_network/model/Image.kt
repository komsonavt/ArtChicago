package com.komsonavt.core_network.model

import com.google.gson.annotations.SerializedName

data class Image (

	@SerializedName("id") val id : String,
	@SerializedName("lake_guid") val lake_guid : String,
	@SerializedName("api_model") val api_model : String,
	@SerializedName("api_link") val api_link : String,
	@SerializedName("title") val title : String,
	@SerializedName("type") val type : String,
	@SerializedName("description") val description : String,
	@SerializedName("alt_text") val alt_text : String,
	@SerializedName("content") val content : String,
	@SerializedName("is_multimedia_resource") val is_multimedia_resource : Boolean,
	@SerializedName("is_educational_resource") val is_educational_resource : Boolean,
	@SerializedName("is_teacher_resource") val is_teacher_resource : Boolean,
	@SerializedName("credit_line") val credit_line : String,
	@SerializedName("content_e_tag") val content_e_tag : String,
	@SerializedName("content_modified_at") val content_modified_at : String,
	@SerializedName("iiif_url") val iiif_url : String,
	@SerializedName("width") val width : Int,
	@SerializedName("height") val height : Int,
	@SerializedName("lqip") val lqip : String,
	@SerializedName("colorfulness") val colorfulness : Double,
	@SerializedName("color") val color : Color,
	@SerializedName("artwork_ids") val artwork_ids : List<String>,
	@SerializedName("artwork_titles") val artwork_titles : List<String>,
	@SerializedName("last_updated_source") val last_updated_source : String,
	@SerializedName("last_updated") val last_updated : String,
	@SerializedName("timestamp") val timestamp : String
)