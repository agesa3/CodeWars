package com.agesadev.codewarstwo.data.remote.dto.detail


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class CreatedBy(
    @Json(name = "url")
    val createdByUrl: String,
    @Json(name = "username")
    val creatorUsername: String
)