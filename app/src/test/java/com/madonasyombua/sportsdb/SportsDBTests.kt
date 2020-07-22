package com.madonasyombua.sportsdb

import android.os.Build
import androidx.room.Room
import com.madonasyombua.sportsdb.data.local.SportDB
import com.madonasyombua.sportsdb.data.local.SportDao
import com.madonasyombua.sportsdb.data.local.SportsEntity
import junit.framework.Assert.assertEquals
import org.hamcrest.CoreMatchers.`is`
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.RuntimeEnvironment
import org.robolectric.annotation.Config


@RunWith(RobolectricTestRunner::class)
@Config(sdk = [Build.VERSION_CODES.O_MR1])
class SportsDBTests {
    private var sportDao: SportDao?= null
    private var sportsDataBase: SportDB? = null
    private var sportsEntity : SportsEntity?= null

    @Before
    fun databaseCreated() {
        // Using an in-memory database because the information stored here disappears when the
        // process is killed.
        // Using an in-memory database because the information stored here disappears when the
        // process is killed.
        sportsDataBase = Room.inMemoryDatabaseBuilder(RuntimeEnvironment.systemContext, SportDB::class.java) //this is just allowed here for testing
                .allowMainThreadQueries()
                .build()
       sportsEntity = SportsEntity(1, "Arsenal", "Premier League","Image")
    }

    @Test
    @Throws(Exception::class)
    fun insertItemsInTheDB() {
        sportsEntity?.let { sportsDataBase?.getSportsDao()?.insertSportsData(it) }
        assertEquals("Arsenal", sportsDataBase?.getSportsDao()?.getAllSports()?.get(0)?.strTeam)
    }

    @Test
    @Throws(Exception::class)
    fun deleteItemsFromTheDB() {
        sportsEntity?.let { sportsDataBase?.getSportsDao()?.insertSportsData(it) }
        sportsEntity?.let { sportsDataBase?.getSportsDao()?.deleteSportsData(it) }
        assertEquals(0, sportsDataBase?.getSportsDao()?.getAllSports()?.size)
    }

    @Test
    @Throws(Exception::class)
    fun testOnConflict(){
        sportsEntity?.let { sportsDataBase?.getSportsDao()?.insertSportsData(it)}
        sportsEntity?.let { sportsDataBase?.getSportsDao()?.insertSportsData(it)}
        assertEquals(1, sportsDataBase?.getSportsDao()?.getAllSports()?.size)
    }

    @Test
    @Throws(Exception::class)
    fun deleteAllSportsData(){
        if(sportsDataBase?.getSportsDao()?.getAllSports()?.isNotEmpty()!!){
            sportsEntity?.let { sportsDataBase?.getSportsDao()?.deleteSportsData(it) }
        }
    }

    @After
    @Throws(Exception::class)
    fun closeTheDB() {
        sportsDataBase?.close()
    }
}