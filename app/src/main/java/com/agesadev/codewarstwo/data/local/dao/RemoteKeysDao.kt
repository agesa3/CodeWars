package com.agesadev.codewarstwo.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.agesadev.codewarstwo.data.local.model.RemoteKeys

@Dao
interface RemoteKeysDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(remoteKey: List<RemoteKeys>)

    @Query("SELECT * FROM challenge_remote_keys WHERE challengeId = :challengeId")
    suspend fun remoteKeysRepoId(challengeId: String): RemoteKeys?

    @Query("DELETE FROM challenge_remote_keys")
    suspend fun clearRemoteKeys()

}