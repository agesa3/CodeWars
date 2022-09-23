package com.agesadev.codewarstwo.data.local.dao


import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.SmallTest
import com.agesadev.codewarstwo.data.local.db.CodeWarsDatabase
import com.agesadev.codewarstwo.data.local.model.ChallengeDetailEntity
import com.agesadev.codewarstwo.data.local.model.RemoteKeys
import com.agesadev.codewarstwo.data.remote.dto.detail.ApprovedBy
import com.agesadev.codewarstwo.data.remote.dto.detail.CreatedBy
import com.agesadev.codewarstwo.data.remote.dto.detail.Rank
import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.runTest
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@SmallTest
class CodeWarsAllDaoTest {

    @get:Rule
    var instanceTaskExecutorRule = InstantTaskExecutorRule()
    private lateinit var codeWarsDatabase: CodeWarsDatabase
    private lateinit var challengesDetailsDao: ChallengeDetailsDao
    private lateinit var remoteKeysDao: RemoteKeysDao
    private lateinit var completedChallengesDao: CompletedChallengesDao

    @Before
    fun setup() {
        codeWarsDatabase = Room.inMemoryDatabaseBuilder(
            ApplicationProvider.getApplicationContext(),
            CodeWarsDatabase::class.java
        ).allowMainThreadQueries().build()
        challengesDetailsDao = codeWarsDatabase.challengeDetailsDao()
        remoteKeysDao = codeWarsDatabase.remoteKeysDao()
        completedChallengesDao = codeWarsDatabase.completedChallengesDao()
    }

    @After
    fun teardown() {
        codeWarsDatabase.close()
    }


    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun should_insert_challenge_details_successfully() = runTest {
        val challengeDetails = ChallengeDetailEntity(
            approvedBy = ApprovedBy(
                usernameApproved = "Agesa",
                approvedByUrl = "https://www.codewars.com/users/Agesa"
            ),
            category = "Algorithms",
            createdBy = CreatedBy(
                createdByUrl = "https://www.codewars.com/users/Agesa",
                creatorUsername = "Agesa"
            ),
            description = "This is a description",
            id = "1",
            languages = listOf("Java", "Kotlin"),
            name = "Test Challenge",
            publishedAt = "2013-11-04T16:17:38.433Z",
            rank = Rank(
                rankId = 1,
                rankName = "1",
                color = "1",
            ),
            slug = "1",
            tags = listOf(
                "Algorithms",
                "Arrays",
            ),
            totalAttempts = 1,
            totalCompleted = 1,
            totalStars = 1
        )
        challengesDetailsDao.saveChallengeDetails(challengeDetails)
        val result = challengesDetailsDao.getChallengeDetailsById("1")
        assertThat(result).isEqualTo(challengeDetails)
    }

    @Test
    fun should_delete_an_item_from_db() = runBlocking {
        val challengeDetails = ChallengeDetailEntity(
            approvedBy = ApprovedBy(
                usernameApproved = "Agesa",
                approvedByUrl = "https://www.codewars.com/users/Agesa"
            ),
            category = "Algorithms",
            createdBy = CreatedBy(
                createdByUrl = "https://www.codewars.com/users/Agesa",
                creatorUsername = "Agesa"
            ),
            description = "This is a description",
            id = "1",
            languages = listOf("Java", "Kotlin"),
            name = "Test Challenge",
            publishedAt = "2013-11-04T16:17:38.433Z",
            rank = Rank(
                rankId = 1,
                rankName = "1",
                color = "1",
            ),
            slug = "1",
            tags = listOf(
                "Algorithms",
                "Arrays",
            ),
            totalAttempts = 1,
            totalCompleted = 1,
            totalStars = 1
        )
        challengesDetailsDao.saveChallengeDetails(challengeDetails)
        challengesDetailsDao.deleteChallengeDetails(challengeDetails.id)
        assertThat(challengesDetailsDao.getChallengeDetailsById(challengeDetails.id)).isNull()
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun should_get_challenge_detail_by_id() = runTest {
        val challengeDetails = ChallengeDetailEntity(
            approvedBy = ApprovedBy(
                usernameApproved = "Agesa",
                approvedByUrl = "https://www.codewars.com/users/Agesa"
            ),
            category = "Algorithms",
            createdBy = CreatedBy(
                createdByUrl = "https://www.codewars.com/users/Agesa",
                creatorUsername = "Agesa"
            ),
            description = "This is a description",
            id = "1",
            languages = listOf("Java", "Kotlin"),
            name = "Test Challenge",
            publishedAt = "2013-11-04T16:17:38.433Z",
            rank = Rank(
                rankId = 1,
                rankName = "1",
                color = "1",
            ),
            slug = "1",
            tags = listOf(
                "Algorithms",
                "Arrays",
            ),
            totalAttempts = 1,
            totalCompleted = 1,
            totalStars = 1
        )
        challengesDetailsDao.saveChallengeDetails(challengeDetails)
        val result = challengesDetailsDao.getChallengeDetailsById(challengeDetails.id)
        assertThat(result).isEqualTo(challengeDetails)
    }

    //remote key dao test
    @Test
    fun should_save_remote_a_list_of_remote_keys() = runTest {
        val remoteKeys = RemoteKeys(
            challengeId = "1",
            prevKey = 1,
            nextKey = 2
        )
        remoteKeysDao.insertAll(listOf(remoteKeys))
        val result = remoteKeysDao.remoteKeysRepoId(remoteKeys.challengeId)
        assertThat(result).isEqualTo(remoteKeys)
    }

    @Test
    fun delete_remote_keys_from_db() = runTest {
        val remoteKey = RemoteKeys(
            challengeId = "1",
            prevKey = 1,
            nextKey = 2
        )
        val remoteKeys = listOf(remoteKey)
        remoteKeysDao.insertAll(remoteKeys)
        remoteKeysDao.clearRemoteKeys()
        val result = remoteKeysDao.remoteKeysRepoId("1")
        assertThat(result).isNull()
    }


////    completed challenges dao test
//    @Test
//    fun should_return_a_list_of_completed_challenges() = runTest {
//        val completedChallenge = CompletedChallengesEntity(
//            completedAt = "2021-05-01T16:17:38.433Z",
//            id = "1",
//            name = "Test Challenge",
//            slug = "1",
//            completedLanguages = listOf("Java", "Kotlin"),
//            username = "Agesa"
//        )
//        val completedChallenges = listOf(completedChallenge)
//        completedChallengesDao.insertCompletedChallenges(completedChallenges)
////     the getCompletedChallenges() method returns  PagingSource<Int, CompletedChallengesEntity>
//        val result = completedChallengesDao.getCompletedChallenges().load(
//            PagingSource.LoadParams.Refresh(
//                key = null,
//                loadSize = 10,
//                placeholdersEnabled = false
//            )
//        )
//        assertThat(result).isEqualTo(PagingSource.LoadResult.Page(
//            data = completedChallenges,
//            prevKey = null,
//            nextKey = null
//        ))
//    }
}