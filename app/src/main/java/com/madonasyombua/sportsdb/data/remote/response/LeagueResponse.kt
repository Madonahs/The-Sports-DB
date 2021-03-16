package com.madonasyombua.sportsdb.data.remote.response

import com.madonasyombua.sportsdb.data.remote.model.League
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class LeagueResponse(
val leagues:List<League>
)
