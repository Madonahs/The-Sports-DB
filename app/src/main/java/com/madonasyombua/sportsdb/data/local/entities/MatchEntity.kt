package com.madonasyombua.sportsdb.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@Entity
@JsonClass(generateAdapter = true)
data class MatchEntity(
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0,
    @Json(name = league) var leagues: String? = null,
    @Json(name = eventDate) var date: String? = null,
    @Json(name = time) var gameTime: String? = null,
    @Json(name = homeTeam) var teamHome: String? = null,
    @Json(name = guestTeam) var awayTeam: String? = null,
    @Json(name = homeScore) var scoreHome: String? = null,
    @Json(name = guestSore) var scoreGuest: String? = null,
    @Json(name = homeTeamId) var homeIdTeam: String? = null,
    @Json(name = awayTeamId) var awayIdTeam: String? = null

) {
    companion object {
        private const val league = "strLeague"
        private const val eventDate = "dateEvent"
        private const val time = "strTime"
        private const val homeTeam = "strHomeTeam"
        private const val guestTeam = "strAwayTeam"
        private const val homeScore = "intHomeScore"
        private const val guestSore = "intAwayScore"
        private const val homeTeamId = "idHomeTeam"
        private const val awayTeamId = "idAwayTeam"

    }
}