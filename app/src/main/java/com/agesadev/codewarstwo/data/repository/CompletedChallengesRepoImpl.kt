package com.agesadev.codewarstwo.data.repository

import android.util.Log
import androidx.paging.*
import com.agesadev.codewarstwo.data.local.db.CodeWarsDatabase
import com.agesadev.codewarstwo.data.mappers.toCompletedChallengesDomain
import com.agesadev.codewarstwo.data.paging.CodeWarsRemoteMediator
import com.agesadev.codewarstwo.data.remote.api.CodeWarsApi
import com.agesadev.codewarstwo.domain.model.CompletedChallengesDomain
import com.agesadev.codewarstwo.domain.repository.CompletedChallengesRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class CompletedChallengesRepoImpl @Inject constructor(
    private val codeWarsApi: CodeWarsApi,
    private val codeWarsDatabase: CodeWarsDatabase
) : CompletedChallengesRepository {
    @OptIn(ExperimentalPagingApi::class)
    override fun getCompletedChallengesByUsername(username: String): Flow<PagingData<CompletedChallengesDomain>> {
        Log.d("Repository", "getCompletedChallengesByUsername: $username")
        val pagingSourceFactory =
            { codeWarsDatabase.completedChallengesDao().getCompletedChallengesByUsername(username) }
        return Pager(
            config = PagingConfig(
                pageSize = NETWORK_PAGE_SIZE,
                enablePlaceholders = false
            ),
            remoteMediator = CodeWarsRemoteMediator(
                username,
                codeWarsApi,
                codeWarsDatabase
            ),
            pagingSourceFactory = pagingSourceFactory
        ).flow.map { pagingData ->
            pagingData.map { completedChallengesEntity ->
                completedChallengesEntity.toCompletedChallengesDomain()
            }
        }
    }

    @OptIn(ExperimentalPagingApi::class)
    override fun getAllCompletedChallenges(): Flow<PagingData<CompletedChallengesDomain>> {
        Log.d("Repository", "getAllCompletedChallenges")
        val pagingSourceFactory =
            { codeWarsDatabase.completedChallengesDao().getCompletedChallenges() }
        return Pager(
            config = PagingConfig(
                pageSize = NETWORK_PAGE_SIZE,
                enablePlaceholders = false
            ),
            remoteMediator = CodeWarsRemoteMediator(
                "matt c",
                codeWarsApi,
                codeWarsDatabase
            ),
            pagingSourceFactory = pagingSourceFactory
        ).flow.map { pagingData ->
            pagingData.map { completedChallengesEntity ->
                completedChallengesEntity.toCompletedChallengesDomain()
            }
        }
    }

    companion object {
        private const val NETWORK_PAGE_SIZE = 50
    }

}