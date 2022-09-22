package com.agesadev.codewarstwo.presentation.screens.challengelist.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.agesadev.codewarstwo.presentation.model.CompletedChallenges
import com.agesadev.codewarstwo.util.TestTags.CHALLENGE_NAME
import com.agesadev.codewarstwo.util.TestTags.DATE_COMPLETED
import com.agesadev.codewarstwo.util.TestTags.LIST_CARD_ITEM
import com.agesadev.codewarstwo.util.dateUtilConverter

@Composable
fun CompletedChallengeItem(
    challenges: CompletedChallenges,
    onChallengeClicked: (CompletedChallenges) -> Unit
) {
    Card(
        elevation = 8.dp,
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable { onChallengeClicked(challenges) }
            .testTag(LIST_CARD_ITEM)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        ) {
            Text(
                text = challenges.name,
                style = MaterialTheme.typography.h6,
                modifier = Modifier
                    .padding(8.dp)
                    .testTag(CHALLENGE_NAME)
            )
            Text(
                text = "Created ${dateUtilConverter(challenges.completedAt)}",
                fontStyle = FontStyle.Italic,
                style = MaterialTheme.typography.body2,
                modifier = Modifier
                    .padding(8.dp)
                    .testTag(DATE_COMPLETED)
            )
        }
    }
}

@Preview
@Composable
fun PreviewCompletedChallengeItem() {
    CompletedChallengeItem(challenges = challengesTest, {})
}

val challengesTest: CompletedChallenges = CompletedChallenges(
    name = "Completed Challenges",
    completedAt = "Completed At",
    id = "id",
    completedLanguages = listOf("Java", "Kotlin"),
    slug = "slug",
    username = "username"
)

//2016-03-03T17:18:53.028Z convert this date to mm/dd/yyyy
