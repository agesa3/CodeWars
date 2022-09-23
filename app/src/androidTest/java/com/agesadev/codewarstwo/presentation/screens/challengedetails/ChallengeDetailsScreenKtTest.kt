package com.agesadev.codewarstwo.presentation.screens.challengedetails

import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.agesadev.codewarstwo.ui.theme.CodewarsTwoTheme
import com.agesadev.codewarstwo.util.TestTags.MY_TEXT
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class ChallengeDetailsScreenKtTest {


    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun testThatTopAppBarIsDisplayed() {
        composeTestRule.setContent {
            CodewarsTwoTheme {
                TopAppBar(title = { Text(text = "Challenge Details") })
            }
        }
        composeTestRule.onNodeWithText("Challenge Details").assertIsDisplayed()

    }

    @Test
    fun testThatMyTitleTextIsDisplayed() {
        composeTestRule.setContent {
            CodewarsTwoTheme {
                MyTitleText(text = "Challenge Details")
            }
        }
        composeTestRule.onNodeWithTag(MY_TEXT).assertIsDisplayed()
    }

}

