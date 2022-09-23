package com.agesadev.codewarstwo.data.local.model

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.agesadev.codewarstwo.data.remote.dto.detail.ApprovedBy
import com.agesadev.codewarstwo.data.remote.dto.detail.CreatedBy
import com.agesadev.codewarstwo.data.remote.dto.detail.Rank
import com.agesadev.codewarstwo.util.Utils.CHALLENGE_DETAILS

@Entity(tableName = CHALLENGE_DETAILS)
data class ChallengeDetailEntity(
    @Embedded
    val approvedBy: ApprovedBy,
    val category: String,
    @Embedded
    val createdBy: CreatedBy,
    val description: String,
    @PrimaryKey
    val id: String,
    @ColumnInfo(name = "challenge_languages")
    val languages: List<String>,
    val name: String,
    val publishedAt: String,
    @Embedded
    val rank: Rank?,
    val slug: String,
    @ColumnInfo(name = "challenge_tags")
    val tags: List<String>,
    val totalAttempts: Int,
    val totalCompleted: Int,
    val totalStars: Int,
)

