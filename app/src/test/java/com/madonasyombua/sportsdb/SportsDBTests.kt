package com.madonasyombua.sportsdb

import android.content.Context
import android.os.Build
import android.support.test.InstrumentationRegistry
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.room.Room
import androidx.test.espresso.matcher.ViewMatchers.assertThat
import com.madonasyombua.sportsdb.data.local.SportDB
import com.madonasyombua.sportsdb.data.local.SportDao
import com.madonasyombua.sportsdb.data.local.SportsEntity
import org.hamcrest.CoreMatchers.`is`
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.RuntimeEnvironment
import org.robolectric.annotation.Config


@RunWith(RobolectricTestRunner::class)
@Config(sdk = [Build.VERSION_CODES.O_MR1])
class SportsDBTests {
    @get:Rule
    @JvmField
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private var sportDao: SportDao?= null
    private var sportsDataBase: SportDB? = null

    @Before
    fun databaseCreated() {
        val context: Context = InstrumentationRegistry.getTargetContext()
        // Using an in-memory database because the information stored here disappears when the
        // process is killed.
        // Using an in-memory database because the information stored here disappears when the
        // process is killed.
        sportsDataBase = Room.inMemoryDatabaseBuilder(RuntimeEnvironment.systemContext, SportDB::class.java) //this is just allowed here for testing
                .allowMainThreadQueries()
                .build()
        sportDao = sportsDataBase?.getSportsDao()




    }

    @Test
    fun insertItemsInTheDB() {
        val sportsEntity = SportsEntity(1, "Arsenal", "Premier League","Image")
        sportDao?.insertSportsData(sportsEntity)

        val sportsEntity1 = SportsEntity(2,"Manchester", "Premier League", "Image")
        sportDao?.insertSportsData(sportsEntity1)

        val allEntries: List<SportsEntity>? = sportDao?.getAllData()
        assertThat(allEntries?.size, `is`(2))
    }

    @Test
    fun deleteItemsFromTheDB() {

    }


    @After
    fun closeTheDB() {
        sportsDataBase?.close()
    }


}