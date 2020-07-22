package com.madonasyombua.sportsdb.data.local

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * This is the sports entity
 */
@Entity
data class SportsEntity (
        @PrimaryKey()
        @ColumnInfo(name = "idTeam") val idTeam : Int,
        @ColumnInfo(name = "strTeam") val strTeam: String,
        @ColumnInfo(name = "strLeague") val strLeague : String,
        @ColumnInfo(name = "strTeamBadge") val strTeamBadge : String
)