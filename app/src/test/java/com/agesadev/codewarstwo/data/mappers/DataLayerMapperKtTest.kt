package com.agesadev.codewarstwo.data.mappers

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.PrimaryKey
import com.agesadev.codewarstwo.data.local.model.ChallengeDetailEntity
import com.agesadev.codewarstwo.data.local.model.CompletedChallengesEntity
import com.agesadev.codewarstwo.data.remote.dto.completed.ChallengesDto
import com.agesadev.codewarstwo.data.remote.dto.completed.CompletedChallengesDto
import com.agesadev.codewarstwo.data.remote.dto.detail.ApprovedBy
import com.agesadev.codewarstwo.data.remote.dto.detail.ChallengeDetailsDto
import com.agesadev.codewarstwo.data.remote.dto.detail.CreatedBy
import com.agesadev.codewarstwo.data.remote.dto.detail.Rank
import com.agesadev.codewarstwo.domain.model.ChallengeDetailsDomain
import com.agesadev.codewarstwo.domain.model.CompletedChallengesDomain
import com.google.common.truth.Truth
import org.junit.Assert.*

import org.junit.Test

class DataLayerMapperKtTest {

    @Test
    fun `should correctly map the challengeEntity to CompletedChallengeDomain`() {
        val completedChallengesEntity = CompletedChallengesEntity(
            completedAt = "2021-01-01",
            completedLanguages = listOf("java"),
            id = "id",
            name = "name",
            slug = "slug",
            username = "username"
        )
        val completedChallengesDomain = CompletedChallengesDomain(
            completedAt = "2021-01-01",
            completedLanguages = listOf("java"),
            id = "id",
            name = "name",
            slug = "slug",
            username = "username"
        )
        assertEquals(
            completedChallengesDomain,
            completedChallengesEntity.toCompletedChallengesDomain()
        )
    }


    @Test
    fun `should map the ChallengesDTO to completedChallengeDomain`() {
        val completedChallengesDomain = CompletedChallengesDomain(
            completedAt = "2021-01-01",
            completedLanguages = listOf("java"),
            id = "id",
            name = "name",
            slug = "slug",
            username = "matt c"
        )

        val challengesDto = ChallengesDto(
            completedAt = "2021-01-01",
            completedLanguages = listOf("java"),
            id = "id",
            name = "name",
            slug = "slug",
        )
        Truth.assertThat(completedChallengesDomain)
            .isEqualTo(challengesDto.toCompletedChallengesDomain())
    }

    @Test
    fun `should map challengeDetailsDTO to challengeDetailsEntity`() {
        val challengeDetailsEntity = ChallengeDetailEntity(
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
        val challengeDetailsDto = ChallengeDetailsDto(
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
            totalStars = 1,
            url = "https://test.com",
            voteScore = 3,
            approvedAt = "12/3/2022"
        )
        Truth.assertThat(challengeDetailsEntity)
            .isEqualTo(challengeDetailsDto.toChallengeDetailsEntity())

    }

    @Test
    fun `should map the challengeDetailsEntity to ChallengeDetailsDomain`() {
        val challengeDetailsEntity = ChallengeDetailEntity(
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

        Truth.assertThat(challengeDetailsDomain)
            .isEqualTo(challengeDetailsEntity.toChallengeDetailsDomain())

    }
}
