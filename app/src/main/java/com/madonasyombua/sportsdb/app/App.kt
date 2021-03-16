package com.madonasyombua.sportsdb.app

import android.app.Application
import com.madonasyombua.sportsdb.BuildConfig
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber

@HiltAndroidApp
open class App : Application() {
    override fun onCreate() {
        super.onCreate()
        setTimberConfiguration()
    }

    protected open fun setTimberConfiguration(){
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }
}