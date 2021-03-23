package com.madonasyombua.sportsdb.data.remote.response

import com.madonasyombua.sportsdb.data.remote.model.Event
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter=true)
data class EventResponse(
    val equipment:List<Event>
)
