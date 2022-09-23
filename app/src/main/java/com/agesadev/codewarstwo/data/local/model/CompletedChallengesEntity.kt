package com.agesadev.codewarstwo.data.local.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.agesadev.codewarstwo.util.Utils.COMPLETED_CHALLENGES

@Entity(tableName = COMPLETED_CHALLENGES)
data class CompletedChallengesEntity(
    val completedAt: String,
    val completedLanguages: List<String>,
    @PrimaryKey
    val id: String,
    val name: String,
    val slug: String,
    val username: String
)