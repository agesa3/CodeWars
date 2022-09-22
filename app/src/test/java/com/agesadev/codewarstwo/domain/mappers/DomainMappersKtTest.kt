package com.agesadev.codewarstwo.domain.mappers

import com.agesadev.codewarstwo.data.remote.dto.detail.ApprovedBy
import com.agesadev.codewarstwo.data.remote.dto.detail.CreatedBy
import com.agesadev.codewarstwo.data.remote.dto.detail.Rank
import com.agesadev.codewarstwo.domain.model.ChallengeDetailsDomain
import com.agesadev.codewarstwo.domain.model.CompletedChallengesDomain
import com.agesadev.codewarstwo.presentation.model.ChallengeDetails
import com.agesadev.codewarstwo.presentation.model.CompletedChallenges
import com.google.common.truth.Truth
import org.junit.Test

class DomainMappersKtTest {


    @Test
    fun `should map CompletedChallengesDomain to CompletedChallenges`() {
        val completedChallengesDomain = CompletedChallengesDomain(
            completedAt = "2021-01-01",
            completedLanguages = listOf("java"),
            id = "id",
            name = "name",
            slug = "slug",
            username = "username"
        )
        val completedChallenges = CompletedChallenges(
            completedAt = "2021-01-01",
            completedLanguages = listOf("java"),
            id = "id",
            name = "name",
            slug = "slug",
            username = "username"
        )

        Truth.assertThat(completedChallenges)
            .isEqualTo(completedChallengesDomain.toCompletedChallenges())
    }

    @Test
    fun `should map ChallengeDetailsDomain to ChallengeDetails`() {
        val challengeDetailsDomain = ChallengeDetailsDomain(
            approvedBy = ApprovedBy(
                approvedByUrl = "https://test.com/agesa",
                usernameApproved = "agesa"
            ),
            category = "Algorithms",
            createdBy = CreatedBy(
                creatorUsername = "agesa",
                createdByUrl = "https://test.com/agesa"
            ),
            description = "Test Description",
            id = "1",
            languages = listOf("java", "kotlin"),
            name = "Test Challenge Details",
            publishedAt = "10/05/2022",
            rank = Rank(
                rankName = "1k",
                rankId = 1,
                color = "Red"
            ),
            slug = "1",
            tags = listOf("algo,data structures"),
            totalAttempts = 1,
            totalCompleted = 1,
            totalStars = 1
        )
        val challengeDetails = ChallengeDetails(
            approvedBy = ApprovedBy(
                approvedByUrl = "https://test.com/agesa",
                usernameApproved = "agesa"
            ),
            category = "Algorithms",
            createdBy = CreatedBy(
                creatorUsername = "agesa",
                createdByUrl = "https://test.com/agesa"
            ),
            description = "Test Description",
            id = "1",
            languages = listOf("java", "kotlin"),
            name = "Test Challenge Details",
            publishedAt = "10/05/2022",
            rank = Rank(
                rankName = "1k",
                rankId = 1,
                color = "Red"
            ),
            slug = "1",
            tags = listOf("algo,data structures"),
            totalAttempts = 1,
            totalCompleted = 1,
            totalStars = 1
        )
        Truth.assertThat(challengeDetails).isEqualTo(challengeDetailsDomain.toChallengeDetails())
    }


}