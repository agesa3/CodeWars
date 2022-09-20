package com.agesadev.codewarstwo.presentation.model

data class CompletedChallenges(
    val completedAt: String,
    val completedLanguages: List<String>,
    val id: String,
    val name: String,
    val slug: String,
    val username: String
)