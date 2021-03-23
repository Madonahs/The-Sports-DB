package com.madonasyombua.sportsdb.data.remote.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

/**
 * Created by Loveth Nwokike
 * 3/23/2021
 * */
@JsonClass(generateAdapter=true)
data class Equipment(
    @Json(name = "idEquipment")
    val equipmentId:String,
    @Json(name="idTeam")
    val teamId:String,
    val date:String,
    @Json(name="strSeason")
    val season:String,
    @Json(name="strEquipment")
    val equipmentUrl:String
)
