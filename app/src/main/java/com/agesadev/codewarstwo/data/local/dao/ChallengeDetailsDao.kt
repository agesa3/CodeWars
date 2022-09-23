package com.agesadev.codewarstwo.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.agesadev.codewarstwo.data.local.model.ChallengeDetailEntity

@Dao
interface ChallengeDetailsDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveChallengeDetails(challengeDetails: ChallengeDetailEntity)

    @Query("SELECT * FROM challenge_details WHERE id = :challengeId")
    suspend fun getChallengeDetailsById(challengeId: String):ChallengeDetailEntity?

    @Query("DELETE FROM challenge_details WHERE  id=:challengeId")
    suspend fun deleteChallengeDetails(challengeId: String)
}