package com.agesadev.codewarstwo.presentation.screens.challengedetails

import com.agesadev.codewarstwo.presentation.model.ChallengeDetails
import okhttp3.Challenge

data class ChallengeDetailsState(
    val isLoading: Boolean = false,
    val challenge: ChallengeDetails? = null,
    val error: String = ""
)
