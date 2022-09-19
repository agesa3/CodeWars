package com.agesadev.codewarstwo.data.remote.api

import com.agesadev.codewarstwo.data.remote.dto.CompletedChallengesDto
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface CodeWarsApi {

    @GET("users/{username}/code-challenges/completed")
    fun getCompletedChallenges(
        @Path("username") username: String,
        @Query("page") page: Int = 0
    ): CompletedChallengesDto
}