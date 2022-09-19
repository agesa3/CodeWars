package com.agesadev.codewarstwo.data.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.agesadev.codewarstwo.data.local.dao.CompletedChallengesDao
import com.agesadev.codewarstwo.data.local.model.CompletedChallengesEntity

@Database(entities = [CompletedChallengesEntity::class], version = 1, exportSchema = false)
abstract class CodeWarsDatabase : RoomDatabase() {
    abstract fun completedChallengesDao(): CompletedChallengesDao

}