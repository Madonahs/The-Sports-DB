package com.madonasyombua.sportsdb.data.remote.response

import com.madonasyombua.sportsdb.data.remote.model.LeagueTable
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class LeagueTableResponse(
    val table:List<LeagueTable>
)
