package com.agesadev.codewarstwo.data.mappers

import com.agesadev.codewarstwo.data.local.model.CompletedChallengesEntity
import com.agesadev.codewarstwo.domain.model.CompletedChallengesDomain


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