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
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.paging.LoadState
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.items
import com.agesadev.codewarstwo.R
import com.agesadev.codewarstwo.presentation.navigation.Screen
import com.agesadev.codewarstwo.presentation.screens.challengelist.components.CompletedChallengeItem
import com.agesadev.codewarstwo.util.TestTags
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
        when (challenges.loadState.prepend) {
            is LoadState.Loading -> {
                item {
                    Column(
                        modifier = Modifier.fillMaxSize(),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        CircularProgressIndicator()
                    }
                }
            }
            is LoadState.Error -> {
                item {
                    Text(text = stringResource(id = R.string.unknown_error))
                }
            }
            is LoadState.NotLoading -> Unit
        }
        when (challenges.loadState.append) {
            is LoadState.Loading -> {
                item {
                    CircularProgressIndicator()
                }
            }
            is LoadState.Error -> {
                item {
                    Text(text = stringResource(id = R.string.unknown_error))
                }
            }
            is LoadState.NotLoading -> Unit
        }
        when (challenges.loadState.refresh) {
            is LoadState.Loading -> {
                item {
                    Column(
                        modifier = Modifier.fillMaxSize(),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        CircularProgressIndicator()
                    }
                }
            }
            is LoadState.Error -> {
                item {
                    Text(text = stringResource(id = R.string.unknown_error))
                }
            }
            is LoadState.NotLoading -> Unit
        }
        items(challenges) { challenge ->
            challenge?.let {
                CompletedChallengeItem(
                    modifier = Modifier.testTag(TestTags.LIST_CARD_ITEM),
                    challenges = challenge, onChallengeClicked = {
                        navController.navigate(
                            Screen.ChallengeDetailScreen.route + "/${challenge.id}"

                        )
                    }
                )
            }
        }
    }
}
