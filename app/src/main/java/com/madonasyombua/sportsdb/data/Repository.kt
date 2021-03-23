package com.madonasyombua.sportsdb.data

import com.madonasyombua.sportsdb.data.remote.api.Api
import javax.inject.Inject

/**
 * Created by Loveth Nwokike
 * on 3/15/2021
 * */
class Repository @Inject constructor(private val api:Api) {

    fun getAllLeagues() = api.getAllLeagues()

    fun getAllTeamsByLeague(league:String) = api.getAllTeamsInALeague(league = league)

    fun getTeamLastFiveEvents(teamId:String)= api.getEventsByTeamID(teamId)

    fun getTeamDetails(teamId: String) = api.getTeamDetailsById(teamId = teamId)
}