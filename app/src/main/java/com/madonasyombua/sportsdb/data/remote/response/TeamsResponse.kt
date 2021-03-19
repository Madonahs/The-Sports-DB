package com.madonasyombua.sportsdb.data.remote.response

import com.madonasyombua.sportsdb.data.remote.model.TeamByLeague
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter=true)
data class TeamsResponse(
    val teams:List<TeamByLeague>
)
