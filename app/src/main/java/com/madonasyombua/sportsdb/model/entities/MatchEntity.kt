package com.madonasyombua.sportsdb.model.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity
data class MatchEntity(
        @PrimaryKey(autoGenerate = true)
        var id : Long = 0,
        @SerializedName(league) var leagues : String? = null,
        @SerializedName(eventDate) var date : String?= null,
        @SerializedName(time) var gameTime : String?=null,
        @SerializedName(homeTeam) var teamHome : String?= null,
        @SerializedName(guestTeam) var awayTeam : String?= null,
        @SerializedName(homeScore) var scoreHome : String?= null,
        @SerializedName(guestSore) var scoreGuest: String? = null,
        @SerializedName(homeTeamId) var homeIdTeam : String? = null,
        @SerializedName(awayTeamId) var awayIdTeam : String? = null

){
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