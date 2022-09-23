package com.agesadev.codewarstwo.data.repository

import com.agesadev.codewarstwo.data.local.db.CodeWarsDatabase
import com.agesadev.codewarstwo.data.mappers.toChallengeDetailsDomain
import com.agesadev.codewarstwo.data.mappers.toChallengeDetailsEntity
import com.agesadev.codewarstwo.data.remote.api.CodeWarsApi
import com.agesadev.codewarstwo.domain.model.ChallengeDetailsDomain
import com.agesadev.codewarstwo.domain.repository.ChallengeDetailsRepository
import com.agesadev.codewarstwo.util.Resource
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class ChallengeDetailsRepositoryImpl @Inject constructor(
    private val codeWarsApi: CodeWarsApi,
    private val codeWarsDatabase: CodeWarsDatabase
) : ChallengeDetailsRepository {
    override suspend fun getChallengeDetails(challengeId: String): Flow<Resource<ChallengeDetailsDomain>> =

        flow {
            val challengeDetails =
                codeWarsDatabase.challengeDetailsDao().getChallengeDetailsById(challengeId)
            //testing if the app will show a progress bar when fetching from db
            coroutineScope {
                delay(500)
            }

            val challengeDetailFromDbResponse = challengeDetails?.toChallengeDetailsDomain()
            challengeDetailFromDbResponse?.let {
                emit(Resource.Success(it))
            }

            if (challengeDetails == null) {
                try {

                    val response = codeWarsApi.getChallengeDetails(challengeId)
                    val challengeDetailsEntity = response.toChallengeDetailsEntity()
                    challengeDetailsEntity.let {
                        codeWarsDatabase.challengeDetailsDao().saveChallengeDetails(it)
                    }

                    val challengeDetailsDomain = challengeDetailsEntity.toChallengeDetailsDomain()

                    emit(Resource.Success(challengeDetailsDomain))
                } catch (e: IOException) {
                    emit(Resource.Error(e.message.toString()))
                } catch (e: HttpException) {
                    emit(Resource.Error(e.message().toString()))
                }
            }
        }
}