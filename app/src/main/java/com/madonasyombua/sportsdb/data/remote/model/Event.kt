package com.madonasyombua.sportsdb.data.remote.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Event(
    @Json(name="idEvent")
    val eventId:String,
    @Json(name="strEvent")
    val twoTeamName:String,
    @Json(name="idLeague")
    val leagueId:String,
    @Json(name="strLeague")
    val leagueName:String,
    @Json(name="strSeason")
    val season:String,
    @Json(name="strHomeTeam")
    val homeTeam:String,
    @Json(name="strAwayTeam")
    val awayTeam:String,
    @Json(name="intHomeScore")
    val homeScore:String,
    @Json(name="intAwayScore")
    val awayScore:String,
    @Json(name="idHomeTeam")
    val homeTeamId:String,
    @Json(name="idAwayTeam")
    val awayTeamId:String,
    @Json(name="strVideo")
    val videoUrl:String

)
