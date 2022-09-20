package com.agesadev.codewarstwo.presentation.screens.challengelist

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import androidx.paging.map
import com.agesadev.codewarstwo.domain.mappers.toCompletedChallenges
import com.agesadev.codewarstwo.domain.usecase.GetCompletedChallengesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ChallengeListViewModel @Inject constructor(
    private val getCompletedChallengesUseCase: GetCompletedChallengesUseCase,
) : ViewModel() {

    //    private val _completedChallenges = mutableStateOf(ChallengeListState())
//    val completedChallenges: State<ChallengeListState> = _completedChallenges
//
//    init {
//        getCompletedChallenges("matt c")
//    }
//
//    private fun getCompletedChallenges(username: String) {
//        viewModelScope.launch {
//            getCompletedChallengesUseCase(username).cachedIn(viewModelScope)
//                .collectLatest { pagingData ->
//                    _completedChallenges.value = ChallengeListState(
//                        challenges = pagingData.map { it.toCompletedChallenges() }
//                    )
//                }
//        }
//    }
    val completedChallenges = getCompletedChallengesUseCase("matt c").cachedIn(viewModelScope)
        .map { pagingData ->
            pagingData.map { it.toCompletedChallenges() }
        }
}



