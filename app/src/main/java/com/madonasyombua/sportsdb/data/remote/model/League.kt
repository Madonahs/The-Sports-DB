package com.madonasyombua.sportsdb.data.remote.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

/**
 * Created by Loveth Nwokike
 * on 3/15/2021
 * */
@JsonClass(generateAdapter = true)
data class League(
    @Json(name = "idLeague")
    val id: String,
    @Json(name = "strLeague")
    val name: String,
    @Json(name = "strSport")
    val sport: String,
    @Json(name = "strLeagueAlternate")
    val alternateName: String?
)