package com.madonasyombua.sportsdb.model.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.madonasyombua.sportsdb.model.dao.MatchDao
import com.madonasyombua.sportsdb.model.dao.TeamDao
import com.madonasyombua.sportsdb.model.entities.MatchEntity
import com.madonasyombua.sportsdb.model.entities.TeamEntity

/**
 * This is the database class
 */
@Database(entities = [TeamEntity::class, MatchEntity::class], version = 1, exportSchema = false)
abstract class SportDB : RoomDatabase(){
    abstract fun getTeamsDao() : TeamDao
    abstract fun getMatchDao() : MatchDao
}