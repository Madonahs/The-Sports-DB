package com.madonasyombua.sportsdb.data.remote.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class League (
    @Json(name = "idLeague")
    val id:String,
    @Json(name = "strLeague")
    val name:String,
    @Json(name = "strSport")
    val sport:String,
    @Json(name = "strLeagueAlternate")
    val alternateName:String?
        )