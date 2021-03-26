package com.madonasyombua.sportsdb.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

/**
 * This is the team entity
 */
@Entity
@JsonClass(generateAdapter = true)
data class TeamEntity(
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0,
    @Json(name = teamId) var idTeam: String? = null,
    @Json(name = teamName) var strTeam: String? = null,
    @Json(name = league) var strLeague: String? = null,
    @Json(name = teamBadge) var strTeamBadge: String? = null
) {
    companion object {
        private const val teamId = "idTeam"
        private const val teamName = "strTeam"
        private const val league = "strLeague"
        private const val teamBadge = "strTeamBadge"
    }
}