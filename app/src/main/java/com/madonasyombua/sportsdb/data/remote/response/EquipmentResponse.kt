package com.madonasyombua.sportsdb.data.remote.response

import com.madonasyombua.sportsdb.data.remote.model.Equipment
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class EquipmentResponse(
    val equipment: List<Equipment>
)
