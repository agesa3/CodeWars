package com.agesadev.codewarstwo.presentation.screens.challengelist.components

import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.agesadev.codewarstwo.presentation.model.CompletedChallenges
import com.agesadev.codewarstwo.ui.theme.CodewarsTwoTheme
import com.agesadev.codewarstwo.util.TestTags.CHALLENGE_NAME
import com.agesadev.codewarstwo.util.TestTags.DATE_COMPLETED
import com.agesadev.codewarstwo.util.TestTags.LIST_CARD_ITEM
import com.agesadev.codewarstwo.util.dateUtilConverter
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class CompletedChallengeItemKtTest {

    @get:Rule
    val composeTestRule = createComposeRule()


    @Before
    fun setUp() {
        composeTestRule.setContent {
            CodewarsTwoTheme {
                CompletedChallengeItem(
                    challenges = CompletedChallenges(
                        name = "Test",
                        completedAt = "2022-06-22T02:22:19.487Z",
                        completedLanguages = listOf("Java", "Kotlin"),
                        username = "Test",
                        id = "Test",
                        slug = "Test",
                    ),
                    onChallengeClicked = {}
                )
            }
        }
    }

    @Test
    fun testThatCardIsDisplayed() {
        composeTestRule.onNodeWithTag(LIST_CARD_ITEM).assertIsDisplayed()
    }

    @Test
    fun testThatChallengeNameIsDisplayed() {
        composeTestRule.onNode(
            hasText("Test"),
            useUnmergedTree = true
        ).assertIsDisplayed()
    }

    @Test
    fun testIfCardIsClickable() {
        composeTestRule.onNodeWithTag(LIST_CARD_ITEM).performClick()
    }

}