package com.agesadev.codewarstwo.presentation.screens.challengedetails

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.agesadev.codewarstwo.data.remote.dto.detail.ApprovedBy
import com.agesadev.codewarstwo.data.remote.dto.detail.CreatedBy
import com.agesadev.codewarstwo.data.remote.dto.detail.Rank
import com.agesadev.codewarstwo.presentation.model.ChallengeDetails
import com.agesadev.codewarstwo.presentation.screens.challengedetails.components.CardItem
import com.agesadev.codewarstwo.presentation.screens.challengedetails.components.ChallengeTag
import com.google.accompanist.flowlayout.FlowRow


@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun ChallengeDetailsScreen(challengeDetailsViewModel: ChallengeDetailsViewModel = hiltViewModel()) {
    val detailState = challengeDetailsViewModel.challengeDetailState.value
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "Challenge Details")
                }
            )
        }
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .fillMaxWidth()
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp)
                    .verticalScroll(rememberScrollState())
            ) {
                Text(
                    text = detailState.challenge?.name ?: "Test Challenge",
                    textAlign = TextAlign.Start,
                    overflow = TextOverflow.Ellipsis,
                )
                Spacer(modifier = Modifier.height(10.dp))
                Text(text = "Created By ${detailState.challenge?.createdBy?.creatorUsername}")
                Spacer(modifier = Modifier.height(10.dp))
                Text(text = "Approved By ${detailState.challenge?.approvedBy?.usernameApproved}")
                Spacer(modifier = Modifier.height(10.dp))
                Text(
                    text = "Description",
                    textAlign = TextAlign.Start,
                    color = Color.Black,
                    style = MaterialTheme.typography.h6
                )
                Text(text = "${detailState.challenge?.description}")
                Spacer(modifier = Modifier.height(10.dp))
                Text(
                    text = "Tags",
                    textAlign = TextAlign.Start,
                    color = Color.Black,
                    style = MaterialTheme.typography.h6
                )
                Spacer(modifier = Modifier.height(10.dp))
                FlowRow(
                    mainAxisSpacing = 8.dp,
                    crossAxisSpacing = 8.dp,
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    detailState.challenge?.tags?.forEach { tag ->
                        ChallengeTag(tag = tag)
                    }
                }
                Spacer(modifier = Modifier.height(10.dp))
                Text(text = "Statistics")
                Spacer(modifier = Modifier.height(10.dp))
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    CardItem(value = detailState.challenge?.totalAttempts ?: 0, "Total Attempts")
                    CardItem(value = detailState.challenge?.totalCompleted ?: 0, "Total Completed")
                    CardItem(value = detailState.challenge?.totalStars ?: 0, "Total Stars")
                }
            }
        }
    }
}


//@Preview
//@Composable
//fun ChallengeDetailsScreenPreview() {
//    ChallengeDetailsScreen(deta = chllengeDetails)
//}
//
//val chllengeDetails = ChallengeDetails(
//    id = "5a01be8cffeeda001a0d7c94",
//    name = "Sum Mixed Array",
//    slug = "sum-mixed-array",
//    description = "Given an array of integers as strings and numbers, return the sum of the array values as if all were numbers.",
//    category = "algorithms",
//    rank = Rank(
//        rankId = 1,
//        rankName = "-4 kyu",
//        color = "#55d500"
//    ),
//    languages = listOf("JavaScript", "Python", "Ruby"),
//    tags = listOf("Fundamentals", "Arrays", "Strings", "Numbers", "Data Types"),
//    approvedBy = ApprovedBy(
//        approvedByUrl = "55a70521798b14d4750000a4",
//        usernameApproved = "jhoffner"
//    ),
//    publishedAt = "2017-11-22T17:51:42.000Z",
//    totalAttempts = 0,
//    totalCompleted = 0,
//    totalStars = 0,
//    createdBy = CreatedBy(
//        creatorUsername = "jhoffner",
//        createdByUrl = "https://www.codewars.com/users/jhoffner"
//    ),
//)
