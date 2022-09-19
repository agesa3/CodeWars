package com.agesadev.codewarstwo.data.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.agesadev.codewarstwo.data.local.dao.CompletedChallengesDao
import com.agesadev.codewarstwo.data.local.dao.RemoteKeysDao
import com.agesadev.codewarstwo.data.local.model.CompletedChallengesEntity
import com.agesadev.codewarstwo.data.local.model.RemoteKeys

@Database(
    entities = [CompletedChallengesEntity::class, RemoteKeys::class],
    version = 1,
    exportSchema = false
)
abstract class CodeWarsDatabase : RoomDatabase() {
    abstract fun completedChallengesDao(): CompletedChallengesDao
    abstract fun remoteKeysDao(): RemoteKeysDao

}