package com.agesadev.codewarstwo.data.remote.api

import com.agesadev.codewarstwo.data.remote.dto.detail.ChallengeDetailsDto
import com.agesadev.codewarstwo.data.remote.dto.completed.CompletedChallengesDto
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface CodeWarsApi {

    @GET("users/{username}/code-challenges/completed")
    suspend fun getCompletedChallenges(
        @Path("username") username: String,
        @Query("page") page: Int = 0
    ): CompletedChallengesDto

    @GET("code-challenges/{challengeId}")
    suspend fun getChallengeDetails(@Path("challengeId") challengeId: String): ChallengeDetailsDto
}