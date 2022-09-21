package com.agesadev.codewarstwo.data.remote.dto.detail


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ApprovedBy(
    @Json(name = "url")
    val approvedByUrl: String,
    @Json(name = "username")
    val usernameApproved: String
)
