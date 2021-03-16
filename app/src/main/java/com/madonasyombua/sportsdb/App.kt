package com.madonasyombua.sportsdb

import android.app.Application
import timber.log.Timber

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