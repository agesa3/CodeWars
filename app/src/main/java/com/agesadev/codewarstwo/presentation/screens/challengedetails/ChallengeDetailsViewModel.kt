package com.agesadev.codewarstwo.presentation.screens.challengedetails

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.agesadev.codewarstwo.domain.mappers.toChallengeDetails
import com.agesadev.codewarstwo.domain.usecase.GetChallengeDetailsUseCase
import com.agesadev.codewarstwo.util.Resource
import com.agesadev.codewarstwo.util.Utils.PARAM_CHALLENGE_ID
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class ChallengeDetailsViewModel @Inject constructor(
    private val getChallengeDetailsUseCase: GetChallengeDetailsUseCase,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _challengeDetailState = mutableStateOf(ChallengeDetailsState())
    val challengeDetailState: State<ChallengeDetailsState> = _challengeDetailState

    init {
        savedStateHandle.get<String>(PARAM_CHALLENGE_ID)?.let { challengeId ->
            getChallengeDetails(challengeId)
        }
    }

    private fun getChallengeDetails(challengeId: String) {
        viewModelScope.launch {
            getChallengeDetailsUseCase(challengeId).collectLatest { result ->
                when (result) {
                    is Resource.Loading -> {
//                        _challengeDetailState.value = ChallengeDetailsState(isLoading = true)
                    }
                    is Resource.Success -> {
                        _challengeDetailState.value = ChallengeDetailsState(
                            isLoading = false,
                            challenge = result.data?.toChallengeDetails()
                        )
                        Timber.tag("ChallengeDetailsScreenViewModel")
                            .d("getChallengeDetails: %s", result.data?.toChallengeDetails())
                    }
                    is Resource.Error -> {
                        _challengeDetailState.value = ChallengeDetailsState(
                            isLoading = false,
                            error = result.message ?: "An unexpected error occurred"
                        )
                        Timber.tag("Error").d("getChallengeDetails: %s", result.message)
                    }
                }
            }

        }
    }
}