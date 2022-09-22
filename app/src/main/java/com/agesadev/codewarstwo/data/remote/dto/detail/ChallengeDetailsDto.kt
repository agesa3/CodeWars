package com.agesadev.codewarstwo.data.remote.dto.detail


import androidx.room.Entity
import androidx.room.PrimaryKey
import com.agesadev.codewarstwo.data.local.model.ChallengeDetailEntity
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ChallengeDetailsDto(
    @Json(name = "approvedAt")
    val approvedAt: String?,
    @Json(name = "approvedBy")
    val approvedBy: ApprovedBy?,
    @Json(name = "category")
    val category: String?,
    @Json(name = "createdBy")
    val createdBy: CreatedBy?,
    @Json(name = "description")
    val description: String?,
    @Json(name = "id")
    val id: String,
    @Json(name = "languages")
    val languages: List<String>?,
    @Json(name = "name")
    val name: String?,
    @Json(name = "publishedAt")
    val publishedAt: String?,
    @Json(name = "rank")
    val rank: Rank?,
    @Json(name = "slug")
    val slug: String?,
    @Json(name = "tags")
    val tags: List<String>?,
    @Json(name = "totalAttempts")
    val totalAttempts: Int?,
    @Json(name = "totalCompleted")
    val totalCompleted: Int?,
    @Json(name = "totalStars")
    val totalStars: Int?,
    @Json(name = "url")
    val url: String?,
    @Json(name = "voteScore")
    val voteScore: Int?
)

