package com.agesadev.codewarstwo.domain.model


data class CompletedChallengesDomain(
    val completedAt: String,
    val completedLanguages: List<String>,
    val id: String,
    val name: String,
    val slug: String,
    val username: String
)