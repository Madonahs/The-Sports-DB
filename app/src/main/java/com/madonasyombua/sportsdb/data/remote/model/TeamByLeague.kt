package com.madonasyombua.sportsdb.data.remote.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter=true)
data class TeamByLeague(
    @Json(name="strTeam")
    val teamName:String,
    @Json(name="strTeamBadge")
    val badgeUrl:String
)
