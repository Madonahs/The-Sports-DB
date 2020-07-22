package com.madonasyombua.sportsdb.data.local

import androidx.room.Database
import androidx.room.RoomDatabase

/**
 * This is the database class
 */
@Database(entities = [SportsEntity::class], version = 1, exportSchema = false)
abstract class SportDB : RoomDatabase(){
    abstract fun getSportsDao() : SportDao
}