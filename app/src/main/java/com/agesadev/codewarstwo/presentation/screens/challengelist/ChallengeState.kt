package com.agesadev.codewarstwo.presentation.screens.challengelist

import androidx.paging.PagingData
import androidx.paging.PagingState
import com.agesadev.codewarstwo.presentation.model.CompletedChallenges
import kotlinx.coroutines.flow.Flow

data class ChallengeListState(
    val isLoading: Boolean = false,
    val challenges: PagingData<CompletedChallenges> = PagingData.empty(),
    val error: Throwable? = null
)