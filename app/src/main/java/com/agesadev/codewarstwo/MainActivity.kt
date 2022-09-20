package com.agesadev.codewarstwo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.agesadev.codewarstwo.presentation.navigation.Screen
import com.agesadev.codewarstwo.presentation.screens.challengedetails.ChallengeDetailsScreen
import com.agesadev.codewarstwo.presentation.screens.challengelist.CompletedChallengesScreen
import com.agesadev.codewarstwo.ui.theme.CodewarsTwoTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CodewarsTwoTheme {
                Surface(color = MaterialTheme.colors.surface) {
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = Screen.CompletedChallengesScreen.route
                    ) {
                        composable(route = Screen.CompletedChallengesScreen.route) {
                            CompletedChallengesScreen(navController)
                        }
                        composable(route = Screen.ChallengeDetailScreen.route + "/{challengeId}") {
                            ChallengeDetailsScreen()
                        }
                    }
                }
            }
        }
    }

}

