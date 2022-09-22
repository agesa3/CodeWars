package com.agesadev.codewarstwo.data.mappers

import com.agesadev.codewarstwo.data.local.model.ChallengeDetailEntity
import com.agesadev.codewarstwo.data.local.model.CompletedChallengesEntity
import com.agesadev.codewarstwo.data.remote.dto.completed.ChallengesDto
import com.agesadev.codewarstwo.data.remote.dto.detail.ApprovedBy
import com.agesadev.codewarstwo.data.remote.dto.detail.ChallengeDetailsDto
import com.agesadev.codewarstwo.data.remote.dto.detail.CreatedBy
import com.agesadev.codewarstwo.data.remote.dto.detail.Rank
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
        completedAt = completedAt ?: "",
        completedLanguages = completedLanguages ?: listOf(),
        id = id,
        name = name ?: "",
        slug = slug ?: "",
        username = TEST_USERNAME,
    )
}

fun ChallengeDetailsDto.toChallengeDetailsEntity(): ChallengeDetailEntity {
    return ChallengeDetailEntity(
        approvedBy = approvedBy ?: ApprovedBy(approvedByUrl = "", usernameApproved = ""),
        category = category ?: "Test Category",
        createdBy = createdBy ?: CreatedBy(createdByUrl = "", creatorUsername = ""),
        description = description ?: "Test Description",
        id = id,
        languages = languages ?: listOf("Test Language"),
        name = name ?: "Test Name",
        publishedAt = publishedAt ?: "Test Published At",
        rank = rank ?: Rank(rankId = 0, rankName = "Test Rank", color = "Test Color"),
        slug = slug ?: "Test Slug",
        tags = tags ?: listOf("Test Tag"),
        totalAttempts = totalAttempts ?: 0,
        totalCompleted = totalCompleted ?: 0,
        totalStars = totalStars ?: 0,
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
        rank = rank ?: Rank(rankId = 0, rankName = "Test Rank", color = "Test Color"),
        slug = slug,
        tags = tags,
        totalAttempts = totalAttempts,
        totalCompleted = totalCompleted,
        totalStars = totalStars
    )
}