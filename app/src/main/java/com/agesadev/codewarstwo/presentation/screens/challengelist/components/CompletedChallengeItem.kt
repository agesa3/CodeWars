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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.agesadev.codewarstwo.presentation.model.CompletedChallenges

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
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        ) {
            Text(
                text = challenges.name,
                style = MaterialTheme.typography.h6,
                modifier = Modifier.padding(8.dp)
            )
            Text(
                text = challenges.completedAt,
                style = MaterialTheme.typography.body2,
                modifier = Modifier.padding(8.dp)
            )
        }
    }
}

@Preview
@Composable
fun PreviewCompletedChallengeItem() {
    CompletedChallengeItem(challenges = challengesTest,{})
}

val challengesTest: CompletedChallenges = CompletedChallenges(
    name = "Completed Challenges",
    completedAt = "Completed At",
    id = "id",
    completedLanguages = listOf("Java", "Kotlin"),
    slug = "slug",
    username = "username"
)