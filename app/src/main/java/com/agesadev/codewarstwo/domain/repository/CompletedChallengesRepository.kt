package com.agesadev.codewarstwo.domain.repository

import androidx.paging.PagingData
import com.agesadev.codewarstwo.domain.model.CompletedChallengesDomain
import kotlinx.coroutines.flow.Flow


interface CompletedChallengesRepository {
    fun getCompletedChallengesByUsername(username: String): Flow<PagingData<CompletedChallengesDomain>>
//    fun getAllCompletedChallenges(): Flow<PagingData<CompletedChallengesDomain>>
//    fun getCompletedChallengesByUsernameFromApi(username: String): Flow<PagingData<CompletedChallengesDomain>>
}