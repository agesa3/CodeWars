package com.agesadev.codewarstwo.data.remote.dto

import com.agesadev.codewarstwo.data.local.model.CompletedChallengesEntity

data class ChallengesDto(
    val completedAt: String,
    val completedLanguages: List<String>,
    val id: String,
    val name: String,
    val slug: String
)

fun ChallengesDto.toCompletedChallengesEntity(): CompletedChallengesEntity {
    return CompletedChallengesEntity(
        completedAt = completedAt,
        completedLanguages = completedLanguages,
        id = id,
        name = name,
        slug = slug,
        username = ""
    )
}