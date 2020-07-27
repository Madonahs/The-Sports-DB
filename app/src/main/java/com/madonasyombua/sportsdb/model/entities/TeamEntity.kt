package com.madonasyombua.sportsdb.model.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

/**
 * This is the team entity
 */
@Entity
data class TeamEntity (
        @PrimaryKey(autoGenerate = true)
        var id: Long = 0,
        @SerializedName(teamId) var idTeam : String? = null,
        @SerializedName(teamName) var strTeam: String? = null,
        @SerializedName(league) var strLeague : String? = null,
        @SerializedName( teamBadge) var strTeamBadge : String? = null
){
        companion object{
                private const val teamId = "idTeam"
                private const val teamName = "strTeam"
                private const val league = "strLeague"
                private const val teamBadge = "strTeamBadge"
        }
}