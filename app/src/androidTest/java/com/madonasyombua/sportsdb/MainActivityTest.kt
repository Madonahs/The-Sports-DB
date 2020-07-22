package com.madonasyombua.sportsdb

import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@LargeTest
@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    //Needed rule to start UI
    @get:Rule
    @JvmField
    val activityTestRule = ScreenUnitTests(
            activityClass = MainActivity::class.java,
            navigateToScreen = {}
    )
    @Before
    @Throws(Exception::class)
    fun intentsInit(){

    }

    @Test
    fun testMain(){

    }

    @After
    @Throws(Exception::class)
    fun intentsTeardown() {

    }


}