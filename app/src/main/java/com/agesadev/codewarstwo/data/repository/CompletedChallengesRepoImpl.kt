package com.agesadev.codewarstwo.data.repository

import androidx.paging.*
import com.agesadev.codewarstwo.data.local.db.CodeWarsDatabase
import com.agesadev.codewarstwo.data.mappers.toCompletedChallengesDomain
import com.agesadev.codewarstwo.data.paging.CodeWarsRemoteMediator
import com.agesadev.codewarstwo.data.remote.api.CodeWarsApi
import com.agesadev.codewarstwo.domain.model.CompletedChallengesDomain
import com.agesadev.codewarstwo.domain.repository.CompletedChallengesRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import timber.log.Timber
import javax.inject.Inject

@OptIn(ExperimentalPagingApi::class)
class CompletedChallengesRepoImpl @Inject constructor(
    private val codeWarsApi: CodeWarsApi,
    private val codeWarsDatabase: CodeWarsDatabase
) : CompletedChallengesRepository {

    override fun getCompletedChallengesByUsername(username: String): Flow<PagingData<CompletedChallengesDomain>> {
        Timber.tag("Repository").d("getCompletedChallengesByUsername: %s", username)

        val pagingSourceFactory =
            { codeWarsDatabase.completedChallengesDao().getCompletedChallengesByUsername(username) }

        return Pager(
            config = PagingConfig(
                pageSize = NETWORK_PAGE_SIZE,
                maxSize = NETWORK_PAGE_SIZE + (NETWORK_PAGE_SIZE * 2),
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

    companion object {
        private const val NETWORK_PAGE_SIZE = 50
    }

}