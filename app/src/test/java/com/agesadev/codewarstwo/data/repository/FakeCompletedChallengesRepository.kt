package com.agesadev.codewarstwo.data.repository

import androidx.paging.PagingData
import com.agesadev.codewarstwo.domain.model.CompletedChallengesDomain
import com.agesadev.codewarstwo.domain.repository.CompletedChallengesRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

class FakeCompletedChallengesRepository : CompletedChallengesRepository {

    private val completedChallenges = mutableListOf<CompletedChallengesDomain>()
    override fun getCompletedChallengesByUsername(username: String): Flow<PagingData<CompletedChallengesDomain>> {
        val challengesByUsername = completedChallenges.filter { it.username == username }
        return flowOf(PagingData.from(challengesByUsername))
    }
}