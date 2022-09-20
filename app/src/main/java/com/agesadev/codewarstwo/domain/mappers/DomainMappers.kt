package com.agesadev.codewarstwo.domain.mappers

import com.agesadev.codewarstwo.domain.model.CompletedChallengesDomain
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
