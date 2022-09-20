package com.agesadev.codewarstwo.presentation.screens.challengelist

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Button
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.paging.LoadState
import androidx.paging.compose.collectAsLazyPagingItems
import com.agesadev.codewarstwo.presentation.navigation.Screen
import com.agesadev.codewarstwo.presentation.screens.challengelist.components.CompletedChallengeItem

@Composable
fun CompletedChallengesScreen(
    navController: NavController,
    viewModel: ChallengeListViewModel = hiltViewModel()
) {

    val challenges = viewModel.completedChallenges.collectAsLazyPagingItems()
    Box(modifier = Modifier.fillMaxSize()) {
        LazyColumn {
            item {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentWidth(Alignment.CenterHorizontally)
                ) {
                    if (challenges.loadState.refresh is LoadState.Loading) {
                        CircularProgressIndicator()
                    }
                }
            }
            items(challenges.itemCount) {
                challenges[it]?.let { challenge ->
                    CompletedChallengeItem(challenge, onChallengeClicked = {
                        navController.navigate(Screen.ChallengeDetailScreen.route + "/${challenge.id}")
                    })
                }
            }
        }
    }

}



@Composable
fun ErrorChallengeItem() {
    val context = LocalContext.current
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentWidth(Alignment.CenterHorizontally)
    ) {
        Button(onClick = {}) {
            Text(text = "Retry")
        }
    }
}

@Composable
fun LoadingChallengeItem() {
    Text(
        text = "Waiting to Load Data",
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentWidth(Alignment.CenterHorizontally)
    )
}
