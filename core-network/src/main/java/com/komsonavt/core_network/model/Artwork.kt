package com.komsonavt.core_network.model

import com.google.gson.annotations.SerializedName

data class Artwork (

	@SerializedName("id") val id : Int?,
	@SerializedName("api_model") val api_model : String?,
	@SerializedName("api_link") val api_link : String,
	@SerializedName("is_boosted") val is_boosted : Boolean,
	@SerializedName("title") val title : String,
	@SerializedName("alt_titles") val alt_titles : List<String>,
	@SerializedName("thumbnail") val thumbnail : Thumbnail,
	@SerializedName("main_reference_number") val main_reference_number : String,
	@SerializedName("has_not_been_viewed_much") val has_not_been_viewed_much : Boolean,
	@SerializedName("boost_rank") val boost_rank : String,
	@SerializedName("date_start") val date_start : String,
	@SerializedName("date_end") val date_end : String,
	@SerializedName("date_display") val date_display : String,
	@SerializedName("date_qualifier_title") val date_qualifier_title : String,
	@SerializedName("date_qualifier_id") val date_qualifier_id : Int,
	@SerializedName("artist_display") val artist_display : String,
	@SerializedName("place_of_origin") val place_of_origin : String,
	@SerializedName("dimensions") val dimensions : String,
	@SerializedName("medium_display") val medium_display : String,
	@SerializedName("inscriptions") val inscriptions : String,
	@SerializedName("credit_line") val credit_line : String?,
	@SerializedName("publication_history") val publication_history : String?,
	@SerializedName("exhibition_history") val exhibition_history : String?,
	@SerializedName("provenance_text") val provenance_text : String,
	@SerializedName("publishing_verification_level") val publishing_verification_level : String,
	@SerializedName("internal_department_id") val internal_department_id : String,
	@SerializedName("fiscal_year") val fiscal_year : String,
	@SerializedName("fiscal_year_deaccession") val fiscal_year_deaccession : String,
	@SerializedName("is_public_domain") val is_public_domain : Boolean,
	@SerializedName("is_zoomable") val is_zoomable : Boolean,
	@SerializedName("max_zoom_window_size") val max_zoom_window_size : Double,
	@SerializedName("copyright_notice") val copyright_notice : String,
	@SerializedName("has_multimedia_resources") val has_multimedia_resources : Boolean,
	@SerializedName("has_educational_resources") val has_educational_resources : Boolean,
	@SerializedName("colorfulness") val colorfulness : Double,
	@SerializedName("color") val color : Color,
	@SerializedName("latitude") val latitude : String,
	@SerializedName("longitude") val longitude : String,
	@SerializedName("latlon") val latlon : String,
	@SerializedName("is_on_view") val is_on_view : Boolean,
	@SerializedName("on_loan_display") val on_loan_display : String,
	@SerializedName("gallery_title") val gallery_title : String,
	@SerializedName("gallery_id") val gallery_id : String,
	@SerializedName("artwork_type_title") val artwork_type_title : String,
	@SerializedName("artwork_type_id") val artwork_type_id : Int,
	@SerializedName("department_title") val department_title : String,
	@SerializedName("department_id") val department_id : String,
	@SerializedName("artist_id") val artist_id : Int,
	@SerializedName("artist_title") val artist_title : String,
	@SerializedName("alt_artist_ids") val alt_artist_ids : List<String>,
	@SerializedName("artist_ids") val artist_ids : List<Int>,
	@SerializedName("artist_titles") val artist_titles : List<String>,
	@SerializedName("category_ids") val category_ids : List<String>,
	@SerializedName("category_titles") val category_titles : List<String>,
	@SerializedName("artwork_catalogue_ids") val artwork_catalogue_ids : List<String>,
	@SerializedName("term_titles") val term_titles : List<String>,
	@SerializedName("style_id") val style_id : String,
	@SerializedName("style_title") val style_title : String,
	@SerializedName("alt_style_ids") val alt_style_ids : List<String>,
	@SerializedName("style_ids") val style_ids : List<String>,
	@SerializedName("style_titles") val style_titles : List<String>,
	@SerializedName("classification_id") val classification_id : String,
	@SerializedName("classification_title") val classification_title : String,
	@SerializedName("alt_classification_ids") val alt_classification_ids : List<String>,
	@SerializedName("classification_ids") val classification_ids : List<String>,
	@SerializedName("classification_titles") val classification_titles : List<String>,
	@SerializedName("subject_id") val subject_id : String,
	@SerializedName("alt_subject_ids") val alt_subject_ids : List<String>,
	@SerializedName("subject_ids") val subject_ids : List<String>,
	@SerializedName("subject_titles") val subject_titles : List<String>,
	@SerializedName("material_id") val material_id : String,
	@SerializedName("alt_material_ids") val alt_material_ids : List<String>,
	@SerializedName("material_ids") val material_ids : List<String>,
	@SerializedName("material_titles") val material_titles : List<String>,
	@SerializedName("technique_id") val technique_id : String,
	@SerializedName("alt_technique_ids") val alt_technique_ids : List<String>,
	@SerializedName("technique_ids") val technique_ids : List<String>,
	@SerializedName("technique_titles") val technique_titles : List<String>,
	@SerializedName("theme_titles") val theme_titles : List<String>,
	@SerializedName("image_id") val image_id : String?,
	@SerializedName("alt_image_ids") val alt_image_ids : List<String>,
	@SerializedName("document_ids") val document_ids : List<String>,
	@SerializedName("sound_ids") val sound_ids : List<String>,
	@SerializedName("video_ids") val video_ids : List<String>,
	@SerializedName("text_ids") val text_ids : List<String>,
	@SerializedName("section_ids") val section_ids : List<String>,
	@SerializedName("section_titles") val section_titles : List<String>,
	@SerializedName("site_ids") val site_ids : List<String>,
	@SerializedName("suggest_autocomplete_all") val suggest_autocomplete_all : List<Suggest_autocomplete_all>,
	@SerializedName("last_updated_source") val last_updated_source : String,
	@SerializedName("last_updated") val last_updated : String,
	@SerializedName("timestamp") val timestamp : String
)