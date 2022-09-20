package com.agesadev.codewarstwo.domain.usecase

import com.agesadev.codewarstwo.domain.repository.CompletedChallengesRepository
import javax.inject.Inject

class GetCompletedChallengesUseCase @Inject constructor(
    private val completedChallengesRepo: CompletedChallengesRepository
) {
    //    operator fun invoke(username: String) =
//        completedChallengesRepo.getCompletedChallengesByUsername(username = username)
    operator fun invoke(username: String) =
        completedChallengesRepo.getCompletedChallengesByUsernameFromApi(username = username)
}