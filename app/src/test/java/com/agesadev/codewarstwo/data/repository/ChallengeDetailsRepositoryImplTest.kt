package com.agesadev.codewarstwo.data.repository

import com.agesadev.codewarstwo.data.repository.fakedata.FakeData
import com.agesadev.codewarstwo.domain.model.ChallengeDetailsDomain
import com.agesadev.codewarstwo.domain.repository.ChallengeDetailsRepository
import com.agesadev.codewarstwo.util.Resource
import kotlinx.coroutines.flow.Flow
import org.junit.Assert.*

import org.junit.Test

class ChallengeDetailsRepositoryImplTest : ChallengeDetailsRepository {

    //    override suspend fun getChallengeDetails(challengeId: String): Flow<Resource<ChallengeDetailsDomain>> {
//     val challengeDetails=FakeData.ChallengeDetailsDomainModel
//
//    }
    override suspend fun getChallengeDetails(challengeId: String): Flow<Resource<ChallengeDetailsDomain>> {
        TODO("Not yet implemented")
    }


}