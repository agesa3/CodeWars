package com.agesadev.codewarstwo.presentation.screens.challengedetails

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.R
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.agesadev.codewarstwo.data.remote.dto.detail.ApprovedBy
import com.agesadev.codewarstwo.data.remote.dto.detail.CreatedBy
import com.agesadev.codewarstwo.data.remote.dto.detail.Rank
import com.agesadev.codewarstwo.presentation.model.ChallengeDetails
import com.agesadev.codewarstwo.presentation.screens.challengedetails.components.CardItem
import com.agesadev.codewarstwo.presentation.screens.challengedetails.components.ChallengeTag
import com.google.accompanist.flowlayout.FlowRow
import dev.jeziellago.compose.markdowntext.MarkdownText


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
                MySpacer(spacerHeight = 10)
                Text(text = "Created By ${detailState.challenge?.createdBy?.creatorUsername}")
                MySpacer(spacerHeight = 10)
                Text(text = "Approved By ${detailState.challenge?.approvedBy?.usernameApproved}")
                MySpacer(spacerHeight = 10)
                Text(
                    text = "Description",
                    textAlign = TextAlign.Start,
                    color = Color.Black,
                    style = MaterialTheme.typography.h6
                )
                MyMarkDownText(markdown = "${detailState.challenge?.description}")
                MySpacer(spacerHeight = 10)
                Text(
                    text = "Tags",
                    textAlign = TextAlign.Start,
                    color = Color.Black,
                    style = MaterialTheme.typography.h6
                )
                MySpacer(spacerHeight = 10)
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
                MySpacer(spacerHeight = 10)
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

@Composable
fun MySpacer(spacerHeight: Int) {
    Spacer(modifier = Modifier.height(spacerHeight.dp))
}

@Composable
fun MyMarkDownText(markdown: String) {
    MarkdownText(
        modifier = Modifier.padding(8.dp),
        markdown = markdown,
        textAlign = TextAlign.Start,
        fontSize = 12.sp,
        color = LocalContentColor.current,
        maxLines = 3,
        style = MaterialTheme.typography.overline,
    )
}