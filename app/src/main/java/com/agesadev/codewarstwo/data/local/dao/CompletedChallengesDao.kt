package com.agesadev.codewarstwo.data.local.dao

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.agesadev.codewarstwo.data.local.model.CompletedChallengesEntity

@Dao
interface CompletedChallengesDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCompletedChallenges(completedChallenges: List<CompletedChallengesEntity>)

    @Query("SELECT * FROM completed_challenges")
    fun getCompletedChallenges(): PagingSource<Int, CompletedChallengesEntity>

    //get challenges by username
    @Query("SELECT * FROM completed_challenges WHERE username = :username")
    fun getCompletedChallengesByUsername(username: String): PagingSource<Int, CompletedChallengesEntity>

    //delete
    @Query("DELETE FROM completed_challenges")
    suspend fun deleteCompletedChallenges()
}