package com.agesadev.codewarstwo.data.remote.dto.completed

data class CompletedChallengesDto(
    val data: List<ChallengesDto>,
    val totalItems: Int,
    val totalPages: Int
)