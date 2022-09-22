package com.agesadev.codewarstwo.data.repository

import android.util.Log
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
import timber.log.Timber
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
//            val challengeDetailFromDbResponse = challengeDetails?.toChallengeDetailsDomain()
//            challengeDetailFromDbResponse?.let {
//                emit(Resource.Success(it))
//            }
        }
}