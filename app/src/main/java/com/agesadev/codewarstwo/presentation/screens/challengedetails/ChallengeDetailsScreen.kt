package com.agesadev.codewarstwo.presentation.screens.challengedetails

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.agesadev.codewarstwo.R
import com.agesadev.codewarstwo.presentation.screens.challengedetails.components.CardItem
import com.agesadev.codewarstwo.presentation.screens.challengedetails.components.ChallengeTag
import com.google.accompanist.flowlayout.FlowRow
import dev.jeziellago.compose.markdowntext.MarkdownText
import timber.log.Timber


@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun ChallengeDetailsScreen(
    navController: NavController,
    challengeDetailsViewModel: ChallengeDetailsViewModel = hiltViewModel()
) {

    val detailState = challengeDetailsViewModel.challengeDetailState.value
    val challengeDetails = detailState.challenge
    val isLoading = detailState.isLoading
    val isError = detailState.error

    Timber.d("ChallengeDetailsScreen here: $challengeDetails")

    challengeDetails?.let {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = {
                        Text(
                            text = challengeDetails.name,
                            color = Color.White,
                            fontSize = 20.sp,
                            textAlign = TextAlign.Center,
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis
                        )
                    },
                    navigationIcon = {
                        IconButton(onClick = { navController.popBackStack() }) {
                            Icon(
                                imageVector = Icons.Filled.ArrowBack,
                                contentDescription = "Back",
                                tint = Color.White
                            )
                        }
                    },
                    backgroundColor = MaterialTheme.colors.primary,
                    elevation = 0.dp
                )
            }
        ) {
            if (isLoading) {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp),
                    contentAlignment = Alignment.Center
                ) {
                    CircularProgressIndicator()
                }
            }
            if (!isError.isNullOrBlank()) {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Text(text = "Error")
                }
            }
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
                    MyTitleText(
                        text = detailState.challenge.name,
                    )
                    MySpacer(spacerHeight = 10)
                    Text(text = "Created By ${detailState.challenge.createdBy.creatorUsername}")
                    MySpacer(spacerHeight = 10)
                    Text(text = "Approved By ${detailState.challenge.approvedBy.usernameApproved}")
                    MySpacer(spacerHeight = 10)
                    MyTitleText(text = stringResource(R.string.description))
                    MyMarkDownText(markdown = detailState.challenge.description)
                    MySpacer(spacerHeight = 10)
                    MyTitleText(text = stringResource(R.string.tags))
                    MySpacer(spacerHeight = 10)
                    FlowRow(
                        mainAxisSpacing = 8.dp,
                        crossAxisSpacing = 8.dp,
                        modifier = Modifier
                            .fillMaxWidth()
                    ) {
                        detailState.challenge.tags.forEach { tag ->
                            ChallengeTag(tag = tag)
                        }
                    }
                    MySpacer(spacerHeight = 10)
                    MyTitleText(text = "Statistics")
                    MySpacer(spacerHeight = 10)
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(10.dp),
                        horizontalArrangement = Arrangement.SpaceEvenly
                    ) {
                        CardItem(
                            value = detailState.challenge.totalAttempts,
                            stringResource(R.string.total_attempts), R.drawable.ic_tag
                        )
                        CardItem(
                            value = detailState.challenge.totalCompleted,
                            stringResource(R.string.total_completed),
                            R.drawable.ic_task_done
                        )
                        CardItem(
                            value = detailState.challenge.totalStars,
                            stringResource(R.string.total_stars),
                            R.drawable.ic_star
                        )
                    }
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
fun MyTitleText(text: String) {
    Text(
        text = text,
        textAlign = TextAlign.Start,
        color = Color.Black,
        style = MaterialTheme.typography.h6
    )
}

@Composable
fun MyMarkDownText(markdown: String) {
    MarkdownText(
        modifier = Modifier.padding(8.dp),
        markdown = markdown,
        textAlign = TextAlign.Start,
        fontSize = 18.sp,
        color = LocalContentColor.current,
        maxLines = 3,
        style = MaterialTheme.typography.overline,
    )
}