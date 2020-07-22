package com.madonasyombua.sportsdb.localdbtests

import android.support.test.runner.AndroidJUnit4
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class SportsDBTests {
    @Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Before
    fun databaseCreated() {


    }

    @Test
    @Throws(InterruptedException::class)
    fun insertItemsInTheDB() {

    }


    @Test
    @Throws(InterruptedException::class)
    fun deleteItemsFromTheDB() {

    }


    @After
    fun closeTheDB() {

    }


}