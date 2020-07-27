package com.madonasyombua.sportsdb.model.response

import com.madonasyombua.sportsdb.model.entities.TeamEntity

data class SportsBaseResponse(val sportList : List<TeamEntity>){
    //check when empty
    fun whenEmpty() = sportList.isEmpty()
}
