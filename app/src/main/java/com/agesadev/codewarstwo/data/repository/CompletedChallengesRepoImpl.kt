package com.agesadev.codewarstwo.data.repository

import androidx.paging.PagingData
import com.agesadev.codewarstwo.data.local.db.CodeWarsDatabase
import com.agesadev.codewarstwo.data.remote.api.CodeWarsApi
import com.agesadev.codewarstwo.domain.model.CompletedChallengesDomain
import com.agesadev.codewarstwo.domain.repository.CompletedChallengesRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class CompletedChallengesRepoImpl @Inject constructor(
    private val codeWarsApi: CodeWarsApi,
    private val codeWarsDatabase: CodeWarsDatabase
) : CompletedChallengesRepository {
    override fun getCompletedChallengesByUsername(username: String): Flow<PagingData<CompletedChallengesDomain>> {
        TODO("Not yet implemented")
    }

    override fun getAllCompletedChallenges(): Flow<PagingData<CompletedChallengesDomain>> {
        TODO("Not yet implemented")
    }

}