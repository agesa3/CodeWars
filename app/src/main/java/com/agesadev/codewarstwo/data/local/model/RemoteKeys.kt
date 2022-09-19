package com.agesadev.codewarstwo.data.local.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "challenge_remote_keys")
data class RemoteKeys(
    @PrimaryKey
    val challengeId: String,
    val prevKey: Int?,
    val nextKey: Int?
)