package com.agesadev.codewarstwo.data.mappers

import com.agesadev.codewarstwo.data.local.model.CompletedChallengesEntity
import com.agesadev.codewarstwo.data.remote.dto.ChallengesDto
import com.agesadev.codewarstwo.data.remote.dto.CompletedChallengesDto
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