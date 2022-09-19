package com.agesadev.codewarstwo.di

import com.agesadev.codewarstwo.data.local.db.CodeWarsDatabase
import com.agesadev.codewarstwo.data.remote.api.CodeWarsApi
import com.agesadev.codewarstwo.data.repository.CompletedChallengesRepoImpl
import com.agesadev.codewarstwo.domain.repository.CompletedChallengesRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun providedCompletedChallengeRepository(
        codeWarsApi: CodeWarsApi,
        codeWarsDatabase: CodeWarsDatabase
    ): CompletedChallengesRepository {
        return CompletedChallengesRepoImpl(
            codeWarsApi = codeWarsApi,
            codeWarsDatabase = codeWarsDatabase
        )
    }
}