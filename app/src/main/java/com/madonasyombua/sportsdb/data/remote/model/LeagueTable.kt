package com.madonasyombua.sportsdb.data.remote.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

/**
 * Created by Loveth Nwokike
 * 3/23/2021
 * */
@JsonClass(generateAdapter = true)
data class LeagueTable(
    @Json(name = "intRank")
    val rankNo: String,
    @Json(name = "idTeam")
    val teamId: String,
    @Json(name = "strTeam")
    val teamName: String,
    @Json(name = "strTeamBadge")
    val teamBadgeUrl: String,
    @Json(name = "idLeague")
    val leagueId: String,
    @Json(name = "strLeague")
    val leagueName: String,
    @Json(name = "strSeason")
    val season: String,
    @Json(name = "strDescription")
    val description: String,
    @Json(name = "intPlayed")
    val noOfGamesPlayed: String,
    @Json(name = "intWin")
    val noOfGamesWon: String,
    @Json(name = "intLoss")
    val noOfGamesLost: String,
    @Json(name = "intDraw")
    val noOfGamesDrawn: String
)
