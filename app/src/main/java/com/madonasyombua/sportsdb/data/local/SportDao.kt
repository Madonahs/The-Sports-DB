package com.madonasyombua.sportsdb.data.local

import androidx.lifecycle.LiveData
import androidx.room.*
import androidx.room.OnConflictStrategy.REPLACE

/**
 * This is the Dao Class
 */
@Dao
interface SportDao {
    @Query("SELECT * FROM sportsentity ORDER By idTeam")
    fun getAllData() : LiveData<List<SportsEntity>>

    @Insert(onConflict = REPLACE)
    fun addSportsData(sportEntity : SportsEntity)

    @Delete
    fun deleteSportsData(sportEntity: SportsEntity)

    @Update(onConflict = REPLACE)
    fun updateSportsData(sportEntity: SportsEntity)
}