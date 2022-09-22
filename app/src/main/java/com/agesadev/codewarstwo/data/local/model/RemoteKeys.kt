package com.agesadev.codewarstwo.data.local.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.agesadev.codewarstwo.util.Utils.REMOTE_KEYS_TABLE

@Entity(tableName = REMOTE_KEYS_TABLE)
data class RemoteKeys(
    @PrimaryKey
    val challengeId: String,
    val prevKey: Int?,
    val nextKey: Int?
)