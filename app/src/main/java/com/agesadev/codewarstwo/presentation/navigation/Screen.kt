package com.agesadev.codewarstwo.presentation.navigation

sealed class Screen(val route: String) {
    object CompletedChallengesScreen : Screen("completed_challenges_screen")
    object ChallengeDetailScreen : Screen("challenge_detail_screen")
}