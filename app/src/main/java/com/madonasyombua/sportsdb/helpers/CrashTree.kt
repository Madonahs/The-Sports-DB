package com.madonasyombua.sportsdb.helpers

import android.util.Log
import com.crashlytics.android.Crashlytics
import timber.log.Timber

class CrashTree : Timber.Tree() {
    override fun log(priority: Int, tag: String?, message: String, throwable: Throwable?) {
        if (priority == Log.VERBOSE || priority == Log.ASSERT || priority == Log.WARN) {
            return
        } else {
            Crashlytics.setInt(CRASHLYTICS_KEY_PRIORITY, priority)
            Crashlytics.setString(CRASHLYTICS_KEY_TAG, tag)
            Crashlytics.setString(CRASHLYTICS_KEY_MESSAGE, message)
            if (throwable == null) {
                Crashlytics.logException(Exception(message))
            } else {
                Crashlytics.logException(throwable)
            }
        }
    }

    companion object {
        private const val CRASHLYTICS_KEY_PRIORITY = "priority"
        private const val CRASHLYTICS_KEY_TAG = "tag"
        private const val CRASHLYTICS_KEY_MESSAGE = "message"
    }
}