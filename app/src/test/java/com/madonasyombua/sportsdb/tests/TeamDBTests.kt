package com.madonasyombua.sportsdb.tests

import android.os.Build
import androidx.room.Room
import com.madonasyombua.sportsdb.data.local.dao.TeamDao
import com.madonasyombua.sportsdb.data.local.database.SportDB
import com.madonasyombua.sportsdb.data.local.entities.TeamEntity
import junit.framework.Assert.assertEquals
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.RuntimeEnvironment
import org.robolectric.annotation.Config

@RunWith(RobolectricTestRunner::class)
@Config(sdk = [Build.VERSION_CODES.O_MR1])
class TeamDBTests {
    private var teamDao: TeamDao? = null
    private var sportsDataBase: SportDB? = null
    private var teamEntity: TeamEntity? = null

    @Before
    fun databaseCreated() {
        // Using an in-memory database because the information stored here disappears when the
        // process is killed.
        // Using an in-memory database because the information stored here disappears when the
        // process is killed.
        sportsDataBase = Room.inMemoryDatabaseBuilder(
            RuntimeEnvironment.systemContext,
            SportDB::class.java
        ) //this is just allowed here for testing
            .allowMainThreadQueries()
            .build()
        teamEntity = TeamEntity(1, "18888", "Arsenal", "Premier League", "Image")
    }

    @Test
    @Throws(Exception::class)
    fun insertItemsInTheDB() {
        teamEntity?.let { sportsDataBase?.getTeamsDao()?.insertSportsData(it) }
        assertEquals("Arsenal", sportsDataBase?.getTeamsDao()?.getAllSports()?.get(0)?.strTeam)
    }

    @Test
    @Throws(Exception::class)
    fun deleteItemsFromTheDB() {
        teamEntity?.let { sportsDataBase?.getTeamsDao()?.insertSportsData(it) }
        teamEntity?.let { sportsDataBase?.getTeamsDao()?.deleteSportsData(it) }
        assertEquals(0, sportsDataBase?.getTeamsDao()?.getAllSports()?.size)
    }

    @Test
    @Throws(Exception::class)
    fun testOnConflict() {
        teamEntity?.let { sportsDataBase?.getTeamsDao()?.insertSportsData(it) }
        teamEntity?.let { sportsDataBase?.getTeamsDao()?.insertSportsData(it) }
        assertEquals(1, sportsDataBase?.getTeamsDao()?.getAllSports()?.size)
    }

    @Test
    @Throws(Exception::class)
    fun deleteAllSportsData() {
        if (sportsDataBase?.getTeamsDao()?.getAllSports()?.isNotEmpty()!!) {
            teamEntity?.let { sportsDataBase?.getTeamsDao()?.deleteSportsData(it) }
        }
    }

    @After
    @Throws(Exception::class)
    fun closeTheDB() {
        sportsDataBase?.close()
    }
}