package com.agesadev.codewarstwo.di

import com.agesadev.codewarstwo.domain.repository.CompletedChallengesRepository
import com.agesadev.codewarstwo.domain.usecase.GetCompletedChallengesUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object UseCasesModule {


    @Provides
    fun provideGetAllUsersUseCase(challengesRepository: CompletedChallengesRepository) =
        GetCompletedChallengesUseCase(challengesRepository)
}
