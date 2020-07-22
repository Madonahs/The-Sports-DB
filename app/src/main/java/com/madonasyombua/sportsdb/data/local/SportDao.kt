package com.madonasyombua.sportsdb.data.local

import androidx.lifecycle.LiveData
import androidx.room.*
import androidx.room.OnConflictStrategy.REPLACE

/**
 * @author madona
 * The data accessible object one of room annotations (DAO class). In this case
 * the DAO provides an api for reading and writing data.
 * We can perform CRUD(create, Read, Update, Delete)
 * A class implements an interface thereby inheriting the abstract methods of the interface
 *
 */
@Dao
interface SportDao {
    @Query("SELECT * FROM sportsentity")
    fun getAllData() : List<SportsEntity>

    @Insert(onConflict = REPLACE)
    fun insertSportsData(sportEntity : SportsEntity)

    @Delete
    fun deleteSportsData(sportEntity: SportsEntity)

    @Update(onConflict = REPLACE)
    fun updateSportsData(sportEntity: SportsEntity)
}