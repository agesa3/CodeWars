package com.agesadev.codewarstwo.presentation.screens.challengelist

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Button
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.paging.LoadState
import androidx.paging.compose.collectAsLazyPagingItems
import com.agesadev.codewarstwo.R
import com.agesadev.codewarstwo.presentation.navigation.Screen
import com.agesadev.codewarstwo.presentation.screens.challengelist.components.CompletedChallengeItem
import com.agesadev.codewarstwo.util.TestTags.LAZY_COLUMN_COMPLETED

@Composable
fun CompletedChallengesScreen(
    navController: NavController,
    viewModel: ChallengeListViewModel = hiltViewModel()
) {

    val challenges = viewModel.completedChallenges.collectAsLazyPagingItems()
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .testTag(LAZY_COLUMN_COMPLETED)
    ) {
        items(challenges.itemCount) { index ->
            challenges[index]?.let { challenge ->
                CompletedChallengeItem(
                    modifier = Modifier.testTag("CARD_ITEM_COMPOSABLE"),
                    challenges = challenge, onChallengeClicked = {
                        navController.navigate(
                            Screen.ChallengeDetailScreen.route + "/${challenge.id}"

                        )
                    })
            }
        }
        challenges.apply {
            when {
                loadState.refresh is LoadState.Loading -> {
                    item {
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .fillMaxHeight(),
                            contentAlignment = Alignment.Center
                        ) {
                            CircularProgressIndicator()
                        }
                    }
                }
                loadState.append is LoadState.Loading -> {
                    item {
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .fillMaxHeight(),
                            contentAlignment = Alignment.Center
                        ) {
                            CircularProgressIndicator()
                        }
                    }
                }
                loadState.refresh is LoadState.Error -> {
                    val e = challenges.loadState.refresh as LoadState.Error
                    item {
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .fillMaxHeight(),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(text = stringResource(R.string.an_error_please_try_again))
                        }
                    }
                }
                loadState.append is LoadState.Error -> {
                    val e = challenges.loadState.append as LoadState.Error
                    item {
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .fillMaxHeight(),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(text = stringResource(R.string.an_error_please_try_again))
                        }
                    }
                }
            }
        }
        challenges.apply {
            when {
                loadState.refresh is LoadState.NotLoading && loadState.append.endOfPaginationReached && itemCount < 1 -> {
                    item {
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .fillMaxHeight(),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(text = stringResource(id = R.string.unknown_error))
                        }
                    }
                }
                loadState.refresh is LoadState.NotLoading && loadState.append.endOfPaginationReached && itemCount > 0 -> {
                    item {
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .fillMaxHeight(),
                            contentAlignment = Alignment.Center
                        ) {
                            Button(onClick = { challenges.retry() }) {
                                Text(text = stringResource(id = R.string.unknown_error))
                            }
                        }
                    }
                }
            }
        }
    }
}
////            item {
//////                Box(
//////                    modifier = Modifier
//////                        .fillMaxWidth()
//////                        .wrapContentWidth(Alignment.CenterHorizontally)
//////                ) {
//////                    if (challenges.loadState.refresh is LoadState.Loading) {
//////                        CircularProgressIndicator()
//////                    }
//////                }
////            }
//        items(challenges.itemCount) {
//            challenges[it]?.let { challenge ->
//                CompletedChallengeItem(challenge, onChallengeClicked = {
//                    navController.navigate(Screen.ChallengeDetailScreen.route + "/${challenge.id}")
//                })
//            }
//        }
//        when (challenges.loadState.append) {
//            is LoadState.Error -> {
//                val error = challenges.loadState.append as LoadState.Error
//                item {
//                    Text(error.error.localizedMessage ?: stringResource(R.string.unknown_error))
//                }
//            }
//            LoadState.Loading -> {
//                item {
//                    CircularProgressIndicator()
//                }
//            }
//            is LoadState.NotLoading -> Unit
//        }
//        when (challenges.loadState.refresh) {
//            is LoadState.Error -> {
//                val error = challenges.loadState.refresh as LoadState.Error
//                item {
//                    Text(error.error.localizedMessage ?: stringResource(R.string.unknown_error))
//                }
//            }
//            LoadState.Loading -> {
//                item {
//                    CircularProgressIndicator()
//                }
//            }
//            is LoadState.NotLoading -> Unit
//        }
//    }
//}
//
//@Composable
//fun ErrorChallengeItem() {
//    val context = LocalContext.current
//    Box(
//        modifier = Modifier
//            .fillMaxWidth()
//            .wrapContentWidth(Alignment.CenterHorizontally)
//    ) {
//        Button(onClick = {}) {
//            Text(text = "Retry")
//        }
//    }
//}
//
//@Composable
//fun LoadingChallengeItem() {
//    Text(
//        text = "Waiting to Load Data",
//        modifier = Modifier
//            .fillMaxWidth()
//            .wrapContentWidth(Alignment.CenterHorizontally)
//    )
//}
