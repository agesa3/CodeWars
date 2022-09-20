package com.agesadev.codewarstwo.domain.repository

import com.agesadev.codewarstwo.domain.model.ChallengeDetailsDomain
import com.agesadev.codewarstwo.presentation.model.ChallengeDetails
import com.agesadev.codewarstwo.util.Resource
import kotlinx.coroutines.flow.Flow

interface ChallengeDetailsRepository {
    suspend fun getChallengeDetails(challengeId: String): Flow<Resource<ChallengeDetailsDomain>>
}