package com.agesadev.codewarstwo.data.remote.dto.detail


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Rank(
    @Json(name = "color")
    val color: String?,
    @Json(name = "id")
    val rankId: Int?,
    @Json(name = "name")
    val rankName: String?,
)