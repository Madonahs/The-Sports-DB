package com.madonasyombua.sportsdb.tests

import androidx.room.Room
import com.madonasyombua.sportsdb.data.local.dao.MatchDao
import com.madonasyombua.sportsdb.data.local.database.SportDB
import com.madonasyombua.sportsdb.data.local.entities.MatchEntity
import junit.framework.TestCase.assertEquals
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.RuntimeEnvironment


@RunWith(RobolectricTestRunner::class)
class MatchDBTests {
    private var matchDao: MatchDao? = null
    private var sportsDataBase: SportDB? = null
    private var matchEntity: MatchEntity? = null

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
        matchEntity = MatchEntity(
            1, "PremierLeague", "07:12:2020", "2:11", "Manchester", "Arsenal",
            "0", "3", "1111", "2222"
        )
    }

    @Test
    @Throws(Exception::class)
    fun insertItemsInTheDB() {
        matchEntity?.let { sportsDataBase?.getMatchDao()?.insertMatchData(it) }
        assertEquals(
            "PremierLeague",
            sportsDataBase?.getMatchDao()?.getAllMatches()?.get(0)?.leagues
        )
    }

    @Test
    @Throws(Exception::class)
    fun deleteItemsFromTheDB() {
        matchEntity?.let { sportsDataBase?.getMatchDao()?.insertMatchData(it) }
        matchEntity?.let { sportsDataBase?.getMatchDao()?.deleteMatchData(it) }
        assertEquals(0, sportsDataBase?.getMatchDao()?.getAllMatches()?.size)
    }

    @Test
    @Throws(Exception::class)
    fun testOnConflict() {
        matchEntity?.let { sportsDataBase?.getMatchDao()?.insertMatchData(it) }
        matchEntity?.let { sportsDataBase?.getMatchDao()?.insertMatchData(it) }
        assertEquals(1, sportsDataBase?.getMatchDao()?.getAllMatches()?.size)
    }

    @Test
    @Throws(Exception::class)
    fun deleteAllSportsData() {
        if (sportsDataBase?.getMatchDao()?.getAllMatches()?.isNotEmpty()!!) {
            matchEntity?.let { sportsDataBase?.getMatchDao()?.deleteMatchData(it) }
        }
    }

    @After
    @Throws(Exception::class)
    fun closeTheDB() {
        sportsDataBase?.close()
    }
}