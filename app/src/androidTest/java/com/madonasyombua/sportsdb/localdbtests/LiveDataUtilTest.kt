package com.madonasyombua.sportsdb.localdbtests

import androidx.annotation.Nullable
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import java.util.concurrent.CountDownLatch
import java.util.concurrent.TimeUnit

class LiveDataUtilTest {
    @Throws(InterruptedException::class)
    fun <T> getValue(tLiveData: LiveData<T>): T? {
        val data = arrayOfNulls<Any>(1)
        val downLatch = CountDownLatch(1)
        val tObserver: Observer<T> = object : Observer<T> {
            override fun onChanged(t: T) {
                data[0] = t
                downLatch.countDown()
                tLiveData.removeObserver(this)
            }
        }
        tLiveData.observeForever(tObserver)
        downLatch.await(2, TimeUnit.SECONDS)
        return data[0] as T?
    }

}