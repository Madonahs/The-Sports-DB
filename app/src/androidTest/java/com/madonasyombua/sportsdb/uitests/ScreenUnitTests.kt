package com.madonasyombua.sportsdb.uitests

import android.app.Activity
import android.support.test.InstrumentationRegistry
import androidx.test.rule.ActivityTestRule
import com.madonasyombua.sportsdb.app.App

class ScreenUnitTests<T : Activity>(
    activityClass: Class<T>,
    private val navigateToScreen: T.() -> Unit,
    private val setupMocks: () -> Unit = {}
) : ActivityTestRule<T>(activityClass) {
    @ExperimentalStdlibApi
    override fun beforeActivityLaunched() {
        val instrumentation = InstrumentationRegistry.getInstrumentation()
        (instrumentation.targetContext.applicationContext as App).run {
            setupMocks()
        }
    }

    override fun afterActivityLaunched() {
        activity.navigateToScreen()
    }
}