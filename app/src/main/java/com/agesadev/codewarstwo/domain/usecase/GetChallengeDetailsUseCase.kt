package com.agesadev.codewarstwo.domain.usecase

import com.agesadev.codewarstwo.domain.repository.ChallengeDetailsRepository
import javax.inject.Inject


class GetChallengeDetailsUseCase @Inject constructor(
    private val challengeDetailsRepository:
    ChallengeDetailsRepository
) {

    suspend operator fun invoke(challengeId: String) =
        challengeDetailsRepository.getChallengeDetails(challengeId)

}