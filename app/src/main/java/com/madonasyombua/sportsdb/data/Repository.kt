package com.madonasyombua.sportsdb.data

import com.madonasyombua.sportsdb.data.remote.api.Api
import javax.inject.Inject

class Repository @Inject constructor(private val api:Api) {

    fun getAllLeagues() = api.getAllLeagues()
}