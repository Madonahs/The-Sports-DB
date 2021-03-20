package com.madonasyombua.sportsdb.data.remote.response

import com.madonasyombua.sportsdb.data.remote.model.TeamByLeague
import com.squareup.moshi.JsonClass

/**
 * Created by Loveth Nwokike
 * on 3/20/2021
 * */
@JsonClass(generateAdapter=true)
data class TeamsResponse(
    val teams:List<TeamByLeague>
)
