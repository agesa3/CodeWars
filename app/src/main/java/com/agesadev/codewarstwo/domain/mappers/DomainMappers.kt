package com.agesadev.codewarstwo.domain.mappers

import com.agesadev.codewarstwo.data.remote.dto.detail.ApprovedBy
import com.agesadev.codewarstwo.data.remote.dto.detail.ChallengeDetailsDto
import com.agesadev.codewarstwo.data.remote.dto.detail.CreatedBy
import com.agesadev.codewarstwo.data.remote.dto.detail.Rank
import com.agesadev.codewarstwo.domain.model.ChallengeDetailsDomain
import com.agesadev.codewarstwo.domain.model.CompletedChallengesDomain
import com.agesadev.codewarstwo.presentation.model.ChallengeDetails
import com.agesadev.codewarstwo.presentation.model.CompletedChallenges

//
//fun <T, R> List<T>.mapList(mapper: (T) -> R): List<R> {
//    return this.map { mapper(it) }
//}

fun CompletedChallengesDomain.toCompletedChallenges(): CompletedChallenges {
    return CompletedChallenges(
        completedAt, completedLanguages, id, name, slug, username
    )
}


fun ChallengeDetailsDomain.toChallengeDetails(): ChallengeDetails {
    return ChallengeDetails(
        approvedBy,
        category,
        createdBy,
        description,
        id,
        languages,
        name,
        publishedAt,
        rank,
        slug,
        tags,
        totalAttempts,
        totalCompleted,
        totalStars
    )
}

