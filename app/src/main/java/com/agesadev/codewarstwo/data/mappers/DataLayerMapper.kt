package com.agesadev.codewarstwo.data.mappers

import com.agesadev.codewarstwo.data.local.model.ChallengeDetailEntity
import com.agesadev.codewarstwo.data.local.model.CompletedChallengesEntity
import com.agesadev.codewarstwo.data.remote.dto.completed.ChallengesDto
import com.agesadev.codewarstwo.data.remote.dto.detail.ChallengeDetailsDto
import com.agesadev.codewarstwo.domain.model.ChallengeDetailsDomain
import com.agesadev.codewarstwo.domain.model.CompletedChallengesDomain
import com.agesadev.codewarstwo.util.Utils.TEST_USERNAME


//fun <T, R> List<T>.mapList(mapper: (T) -> R): List<R> {
//    return this.map { mapper(it) }
//}

fun CompletedChallengesEntity.toCompletedChallengesDomain(): CompletedChallengesDomain {
    return CompletedChallengesDomain(
        completedAt = completedAt,
        completedLanguages = completedLanguages,
        id = id,
        name = name,
        slug = slug,
        username = username
    )
}

fun ChallengesDto.toCompletedChallengesDomain(): CompletedChallengesDomain {
    return CompletedChallengesDomain(
        completedAt = completedAt,
        completedLanguages = completedLanguages,
        id = id,
        name = name,
        slug = slug,
        username = TEST_USERNAME,
    )
}

fun ChallengeDetailsDto.toChallengeDetailsEntity(): ChallengeDetailEntity {
    return ChallengeDetailEntity(
        approvedBy = approvedBy,
        category = category,
        createdBy = createdBy,
        description = description,
        id = id,
        languages = languages,
        name = name,
        publishedAt = publishedAt,
        rank = rank,
        slug = slug,
        tags = tags,
        totalAttempts = totalAttempts,
        totalCompleted = totalCompleted,
        totalStars = totalStars
    )
}

fun ChallengeDetailEntity.toChallengeDetailsDomain(): ChallengeDetailsDomain {
    return ChallengeDetailsDomain(
        approvedBy = approvedBy,
        category = category,
        createdBy = createdBy,
        description = description,
        id = id,
        languages = languages,
        name = name,
        publishedAt = publishedAt,
        rank = rank,
        slug = slug,
        tags = tags,
        totalAttempts = totalAttempts,
        totalCompleted = totalCompleted,
        totalStars = totalStars
    )
}