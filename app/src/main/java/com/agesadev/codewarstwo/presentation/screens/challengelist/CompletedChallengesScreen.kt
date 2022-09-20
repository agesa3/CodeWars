package com.agesadev.codewarstwo.presentation.screens.challengelist

import android.widget.Toast
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.flatMap
import com.agesadev.codewarstwo.presentation.navigation.Screen
import com.agesadev.codewarstwo.presentation.screens.challengelist.components.CompletedChallengeItem

@Composable
fun CompletedChallengesScreen(
    navController: NavController,
    viewModel: ChallengeListViewModel = hiltViewModel()
) {
//    val challenges = viewModel.completedChallenges.value
//    val mContext = LocalContext.current
//    Box(modifier = Modifier.fillMaxSize()) {
//        Toast.makeText(
//            mContext,
//            "Completed Challenges are ${challenges.challenges to List::class.java}",
//            Toast.LENGTH_SHORT
//        ).show()
////        LazyColumn {
////            items(challenges.challenges.size) {
////                CompletedChallengeItem(challenges[it])
////            }
////        }
//
//    }

    val challenges = viewModel.completedChallenges.collectAsLazyPagingItems()
    Box(modifier = Modifier.fillMaxSize()) {
        LazyColumn {
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