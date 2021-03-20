package com.madonasyombua.sportsdb.data.remote.response

import com.madonasyombua.sportsdb.data.remote.model.League
import com.squareup.moshi.JsonClass

/**
 * Created by Loveth Nwokike
 * on 3/15/2021
 * */
@JsonClass(generateAdapter = true)
data class LeagueResponse(
val leagues:List<League>
)
