package com.agesadev.codewarstwo.data.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.agesadev.codewarstwo.data.remote.api.CodeWarsApi
import com.agesadev.codewarstwo.data.remote.dto.ChallengesDto
import com.agesadev.codewarstwo.util.Utils.CODEWARS_STARTING_INDEX
import retrofit2.HttpException
import java.io.IOException


class CodeWarsPagingSource(
    private val codeWarsApi: CodeWarsApi,
    private val query: String
) : PagingSource<Int, ChallengesDto>() {
    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, ChallengesDto> {
        val position = params.key ?: CODEWARS_STARTING_INDEX
        return try {
            val response = codeWarsApi.getCompletedChallenges(query, position)
            val userChallenges = response.data
            LoadResult.Page(
                data = userChallenges,
                prevKey = if (position == CODEWARS_STARTING_INDEX) null else position - 1,
                nextKey = if (userChallenges.isEmpty()) null else position + 1
            )
        } catch (e: IOException) {
            LoadResult.Error(e)
        } catch (e: HttpException) {
            LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, ChallengesDto>): Int? {
        return state.anchorPosition.let { anchorPosition ->
            anchorPosition?.let { state.closestPageToPosition(it)?.prevKey?.plus(1) }
                ?: anchorPosition?.let { state.closestPageToPosition(it)?.nextKey?.minus(1) }

        }
    }
}
