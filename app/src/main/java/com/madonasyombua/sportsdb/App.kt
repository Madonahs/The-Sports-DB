package com.madonasyombua.sportsdb

import android.app.Application
import androidx.databinding.library.BuildConfig
import timber.log.Timber

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        //plant Timber for logging only on debug mode
        if (BuildConfig.DEBUG)
            Timber.plant(Timber.DebugTree())
    }
}