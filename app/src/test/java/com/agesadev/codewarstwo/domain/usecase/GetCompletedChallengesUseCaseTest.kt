package com.agesadev.codewarstwo.domain.usecase

import com.agesadev.codewarstwo.data.repository.FakeCompletedChallengesRepository
import com.agesadev.codewarstwo.domain.model.CompletedChallengesDomain
import com.google.common.truth.Truth
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

class GetCompletedChallengesUseCaseTest {
    private lateinit var getCompletedChallengesUseCase: GetCompletedChallengesUseCase
    private lateinit var fakeCompletedChallengesRepository: FakeCompletedChallengesRepository


    @Before
    fun setUp() {
        fakeCompletedChallengesRepository = FakeCompletedChallengesRepository()
        getCompletedChallengesUseCase =
            GetCompletedChallengesUseCase(fakeCompletedChallengesRepository)

        val completedChallengesToInsert = mutableListOf<CompletedChallengesDomain>()
        val completedChallengesDomain1 = CompletedChallengesDomain(
            completedAt = "2021-01-01",
            completedLanguages = listOf("java"),
            id = "id",
            name = "name",
            slug = "slug",
            username = "username"
        )
        val completedChallengesDomain2 = CompletedChallengesDomain(
            completedAt = "2021-01-01",
            completedLanguages = listOf("java"),
            id = "id",
            name = "name",
            slug = "slug",
            username = "username"
        )
        val completedChallengesDomain3 = CompletedChallengesDomain(
            completedAt = "2021-01-01",
            completedLanguages = listOf("java"),
            id = "id",
            name = "name",
            slug = "slug",
            username = "username"
        )
        completedChallengesToInsert.apply {
            add(completedChallengesDomain1)
            add(completedChallengesDomain2)
            add(completedChallengesDomain3)
        }

    }

    @Test
    fun `get completed challenges from repository`() = runBlocking {
        val result = getCompletedChallengesUseCase("username").first()
        Truth.assertThat(result).isNotNull()
    }

}