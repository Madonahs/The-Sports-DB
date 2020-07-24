package com.madonasyombua.sportsdb

import android.app.Application
import androidx.databinding.library.BuildConfig
import com.madonasyombua.sportsdb.helpers.CrashTree
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
        Timber.plant(CrashTree())
    }
}