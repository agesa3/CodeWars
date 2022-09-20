package com.agesadev.codewarstwo.data.paging

import androidx.paging.ExperimentalPagingApi
import androidx.paging.LoadType
import androidx.paging.PagingState
import androidx.paging.RemoteMediator
import androidx.room.withTransaction
import com.agesadev.codewarstwo.data.local.db.CodeWarsDatabase
import com.agesadev.codewarstwo.data.local.model.CompletedChallengesEntity
import com.agesadev.codewarstwo.data.local.model.RemoteKeys
import com.agesadev.codewarstwo.data.remote.api.CodeWarsApi
import com.agesadev.codewarstwo.data.remote.dto.toCompletedChallengesEntity
import retrofit2.HttpException
import java.io.IOException

@OptIn(ExperimentalPagingApi::class)
class CodeWarsRemoteMediator(
    private val query: String,
    private val codeWarsApi: CodeWarsApi,
    private val codeWarsDatabase: CodeWarsDatabase
) : RemoteMediator<Int, CompletedChallengesEntity>() {

    override suspend fun initialize(): InitializeAction {
        return InitializeAction.LAUNCH_INITIAL_REFRESH
    }

    override suspend fun load(
        loadType: LoadType,
        state: PagingState<Int, CompletedChallengesEntity>
    ): MediatorResult {
        val page = when (loadType) {
            LoadType.REFRESH -> {
                val remoteKeys = getRemoteKeyClosestToCurrentPosition(state)
                remoteKeys?.nextKey?.minus(1) ?: CODE_WARS_STARTING_PAGE_INDEX
            }
            LoadType.PREPEND -> {
                val remoteKeys = getRemoteKeyForFirstItem(state)
                val prevKey = remoteKeys?.prevKey
                if (prevKey == null) {
                    return MediatorResult.Success(endOfPaginationReached = true)
                }
                prevKey
            }
            LoadType.APPEND -> {
                val remoteKeys = getRemoteKeyForLastItem(state)
                val nextKey = remoteKeys?.nextKey
                if (nextKey == null) {
                    return MediatorResult.Success(endOfPaginationReached = true)
                }
                nextKey
            }
        }
        try {
            val apiResponse = codeWarsApi.getCompletedChallenges(username = query, page = page)
            val challenges = apiResponse.data
            val endOfPaginationReached = challenges.isEmpty()
            codeWarsDatabase.withTransaction {
                if (loadType == LoadType.REFRESH) {
                    codeWarsDatabase.remoteKeysDao().clearRemoteKeys()
                    codeWarsDatabase.completedChallengesDao().deleteCompletedChallenges()
                }
                val prevKey = if (page == CODE_WARS_STARTING_PAGE_INDEX) null else page - 1
                val nextKey = if (endOfPaginationReached) null else page + 1
                val keys = challenges.map {
                    RemoteKeys(challengeId = it.id, prevKey = prevKey, nextKey = nextKey)
                }
                codeWarsDatabase.remoteKeysDao().insertAll(keys)
                codeWarsDatabase.completedChallengesDao()
                    .insertCompletedChallenges(challenges.map { it.toCompletedChallengesEntity() })
            }
            return MediatorResult.Success(endOfPaginationReached = false)
        } catch (exception: IOException) {
            return MediatorResult.Error(exception)
        } catch (exception: HttpException) {
            return MediatorResult.Error(exception)
        }

    }

    private suspend fun getRemoteKeyForLastItem(state: PagingState<Int, CompletedChallengesEntity>): RemoteKeys? {
        return state.pages.lastOrNull { it.data.isNotEmpty() }?.data?.lastOrNull()
            ?.let { challenge ->
                codeWarsDatabase.remoteKeysDao().remoteKeysRepoId(challenge.id)
            }
    }

    private suspend fun getRemoteKeyForFirstItem(state: PagingState<Int, CompletedChallengesEntity>): RemoteKeys? {
        return state.pages.firstOrNull { it.data.isNotEmpty() }?.data?.firstOrNull()
            ?.let { challenge ->
                codeWarsDatabase.remoteKeysDao().remoteKeysRepoId(challenge.id)
            }
    }

    private suspend fun getRemoteKeyClosestToCurrentPosition(
        state: PagingState<Int, CompletedChallengesEntity>
    ): RemoteKeys? {
        return state.anchorPosition?.let { position ->
            state.closestItemToPosition(position)?.id?.let { challengeId ->
                codeWarsDatabase.remoteKeysDao().remoteKeysRepoId(challengeId)
            }
        }
    }

    companion object {
        private const val CODE_WARS_STARTING_PAGE_INDEX = 0
    }
}