package com.agesadev.codewarstwo.presentation.screens.challengelist

import androidx.activity.compose.setContent
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.agesadev.codewarstwo.MainActivity
import com.agesadev.codewarstwo.di.DatabaseModule
import com.agesadev.codewarstwo.di.NetworkModule
import com.agesadev.codewarstwo.di.RepositoryModule
import com.agesadev.codewarstwo.di.UseCasesModule
import com.agesadev.codewarstwo.presentation.navigation.Screen
import com.agesadev.codewarstwo.ui.theme.CodewarsTwoTheme
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import dagger.hilt.android.testing.UninstallModules
import org.junit.Before
import org.junit.Rule
import org.junit.Test


@HiltAndroidTest
@UninstallModules(
    UseCasesModule::class,
    RepositoryModule::class,
    DatabaseModule::class,
    NetworkModule::class
)
class CompletedChallengesScreenKtTest {

    @get:Rule(order = 0)
    var hiltRule = HiltAndroidRule(this)

    @get:Rule(order = 1)
    val composeRule = createAndroidComposeRule<MainActivity>()

    @Before
    fun setup() {
        hiltRule.inject()
        composeRule.activity.setContent {
            val navController = rememberNavController()
            CodewarsTwoTheme {
                NavHost(
                    navController = navController,
                    startDestination = Screen.CompletedChallengesScreen.route
                ) {
                    composable(route = Screen.CompletedChallengesScreen.route) {
                        CompletedChallengesScreen(navController)
                    }
                }
            }
        }
    }

    @Test
    fun testLazyColumn() {
        composeRule.onNodeWithTag("lazyColumnCompleted").assertIsDisplayed()
    }

}