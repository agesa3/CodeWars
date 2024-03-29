package com.agesadev.codewarstwo.di

import android.content.Context
import androidx.room.Room
import com.agesadev.codewarstwo.data.local.dao.CompletedChallengesDao
import com.agesadev.codewarstwo.data.local.db.CodeWarsDatabase
import com.agesadev.codewarstwo.util.Utils
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object DatabaseModuleTest {

    //provide database
    @Singleton
    @Provides
    fun providesCodeWarsDatabase(@ApplicationContext applicationContext: Context): CodeWarsDatabase {
        return Room.inMemoryDatabaseBuilder(
            applicationContext,
            CodeWarsDatabase::class.java
        ).build()
    }


    @Provides
    fun providesCompletedChallengesDao(codeWarsDatabase: CodeWarsDatabase): CompletedChallengesDao {
        return codeWarsDatabase.completedChallengesDao()
    }
}