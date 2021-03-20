package com.madonasyombua.sportsdb.data.remote.response

import com.madonasyombua.sportsdb.data.local.entities.TeamEntity

data class SportsBaseResponse(val sportList : List<TeamEntity>){
    //check when empty
    fun whenEmpty() = sportList.isEmpty()
}
