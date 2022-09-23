package com.agesadev.codewarstwo.data.repository.fakedata

import com.agesadev.codewarstwo.data.remote.dto.completed.ChallengesDto
import com.agesadev.codewarstwo.data.remote.dto.completed.CompletedChallengesDto
import com.agesadev.codewarstwo.data.remote.dto.detail.ApprovedBy
import com.agesadev.codewarstwo.data.remote.dto.detail.ChallengeDetailsDto
import com.agesadev.codewarstwo.data.remote.dto.detail.CreatedBy
import com.agesadev.codewarstwo.data.remote.dto.detail.Rank
import com.agesadev.codewarstwo.util.Utils

object Data {
    object ChallengeDetailData {
        val challengeDetailsResponse = ChallengeDetailsDto(
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

    }

    object CompletedChallengesData {
        val completedChallengesResponse = CompletedChallengesDto(
            listOf(
                ChallengesDto(
                    completedAt = "12/3/2022",
                    completedLanguages = listOf("java", "kotlin"),
                    id = "1",
                    name = "Agesa",
                    slug = "1"
                ), ChallengesDto(
                    completedAt = "12/3/2022",
                    completedLanguages = listOf("java", "kotlin"),
                    id = "1",
                    name = "Agesa",
                    slug = "1"
                ), ChallengesDto(
                    completedAt = "12/3/2022",
                    completedLanguages = listOf("java", "kotlin"),
                    id = "1",
                    name = "Agesa",
                    slug = "1"
                )
            ),
            totalItems = 3,
            totalPages = 1,
        )
    }
}
