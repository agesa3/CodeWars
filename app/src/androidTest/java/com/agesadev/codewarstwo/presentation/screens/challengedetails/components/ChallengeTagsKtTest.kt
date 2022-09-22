package com.agesadev.codewarstwo.presentation.screens.challengedetails.components

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.agesadev.codewarstwo.ui.theme.CodewarsTwoTheme
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class ChallengeTagsKtTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Before
    fun setUp() {
        composeTestRule.setContent {
            CodewarsTwoTheme {
                ChallengeTag("test tag")
            }
        }
    }

    @Test
    fun testThatChallengeTagIsDisplayed() {
        composeTestRule.onNodeWithText("test tag").assertIsDisplayed()
    }

}