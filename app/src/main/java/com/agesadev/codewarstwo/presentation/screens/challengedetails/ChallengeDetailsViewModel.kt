package com.agesadev.codewarstwo.presentation.screens.challengedetails

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.agesadev.codewarstwo.domain.mappers.toChallengeDetails
import com.agesadev.codewarstwo.domain.usecase.GetChallengeDetailsUseCase
import com.agesadev.codewarstwo.util.ConnectivityObserver
import com.agesadev.codewarstwo.util.Resource
import com.agesadev.codewarstwo.util.Utils.PARAM_CHALLENGE_ID
import com.agesadev.codewarstwo.util.Utils.TEST_USERNAME
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.onStart
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
    val challengeId = savedStateHandle.get<String>(PARAM_CHALLENGE_ID)

    init {
        if (challengeId != null) {
            savedStateHandle.get<String>(PARAM_CHALLENGE_ID)?.let { getChallengeDetails(it) }
        }
    }

    private fun getChallengeDetails(challengeId: String) {
        viewModelScope.launch {
            getChallengeDetailsUseCase(challengeId).onStart {
                _challengeDetailState.value = ChallengeDetailsState(isLoading = true)
                Timber.tag("ViewModel").d("getChallengeDetails: %s", _challengeDetailState.value)
            }.collectLatest { result ->
                when (result) {
                    is Resource.Error -> {
                        Timber.tag("ViewModel").d("%s ", "getChallengeDetails:" + result.message)
                        _challengeDetailState.value =
                            ChallengeDetailsState(isLoading = false, error = result.message ?: "")
                    }
                    is Resource.Success -> {
                        Timber.tag("ViewModel").d("getChallengeDetails: %s", result.data)
                        _challengeDetailState.value =
                            ChallengeDetailsState(
                                isLoading = false,
                                challenge = result.data?.toChallengeDetails()
                            )
                    }
                }

            }
        }
    }

    fun retry() {
        challengeId?.let { getChallengeDetails(it) }
    }

}