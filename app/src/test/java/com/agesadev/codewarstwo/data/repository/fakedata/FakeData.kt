package com.agesadev.codewarstwo.data.repository.fakedata

import com.agesadev.codewarstwo.data.remote.dto.detail.ApprovedBy
import com.agesadev.codewarstwo.data.remote.dto.detail.CreatedBy
import com.agesadev.codewarstwo.data.remote.dto.detail.Rank
import com.agesadev.codewarstwo.domain.model.ChallengeDetailsDomain

object FakeData {

    object ChallengeDetailsDomainModel {
        val challengeDetail = ChallengeDetailsDomain(
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

    }
}