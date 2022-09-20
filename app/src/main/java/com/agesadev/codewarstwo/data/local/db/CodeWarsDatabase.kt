package com.agesadev.codewarstwo.data.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.agesadev.codewarstwo.data.local.converters.ListStringConverter
import com.agesadev.codewarstwo.data.local.dao.ChallengeDetailsDao
import com.agesadev.codewarstwo.data.local.dao.CompletedChallengesDao
import com.agesadev.codewarstwo.data.local.dao.RemoteKeysDao
import com.agesadev.codewarstwo.data.local.model.ChallengeDetailEntity
import com.agesadev.codewarstwo.data.local.model.CompletedChallengesEntity
import com.agesadev.codewarstwo.data.local.model.RemoteKeys

@Database(
    entities = [CompletedChallengesEntity::class, RemoteKeys::class, ChallengeDetailEntity::class],
    version = 1,
    exportSchema = false
)
@TypeConverters(ListStringConverter::class)
abstract class CodeWarsDatabase : RoomDatabase() {
    abstract fun completedChallengesDao(): CompletedChallengesDao
    abstract fun remoteKeysDao(): RemoteKeysDao
    abstract fun challengeDetailsDao(): ChallengeDetailsDao

}