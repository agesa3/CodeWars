package com.agesadev.codewarstwo.domain.model

import com.agesadev.codewarstwo.data.remote.dto.detail.ApprovedBy
import com.agesadev.codewarstwo.data.remote.dto.detail.CreatedBy
import com.agesadev.codewarstwo.data.remote.dto.detail.Rank

data class ChallengeDetailsDomain(
    val approvedBy: ApprovedBy,
    val category: String,
    val createdBy: CreatedBy,
    val description: String,
    val id: String,
    val languages: List<String>,
    val name: String,
    val publishedAt: String,
    val rank: Rank,
    val slug: String,
    val tags: List<String>,
    val totalAttempts: Int,
    val totalCompleted: Int,
    val totalStars: Int,
)