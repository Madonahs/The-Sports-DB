package com.madonasyombua.sportsdb.model.dao

import androidx.room.Delete
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import androidx.room.OnConflictStrategy.REPLACE
import com.madonasyombua.sportsdb.model.entities.TeamEntity

/**
 * @author madona
 * The data accessible object one of room annotations (DAO class). In this case
 * the DAO provides an api for reading and writing data.
 * We can perform CRUD(create, Read, Update, Delete)
 * A class implements an interface thereby inheriting the abstract methods of the interface
 *
 */
@Dao
interface TeamDao {
    @Query("SELECT * FROM teamentity")
    fun getAllSports() : List<TeamEntity>

    @Insert(onConflict = REPLACE)
    fun insertSportsData(sportEntity : TeamEntity)

    @Delete
    fun deleteSportsData(sportEntity: TeamEntity)

    @Update(onConflict = REPLACE)
    fun updateSportsData(sportEntity: TeamEntity)
}