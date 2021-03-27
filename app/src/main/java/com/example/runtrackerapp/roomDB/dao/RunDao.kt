package com.example.runtrackerapp.roomDB.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.runtrackerapp.roomDB.entities.Run

@Dao
interface RunDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(run: Run)

    @Delete
    suspend fun delete(run: Run)

    @Query("SELECT * FROM running_table ORDER BY timestamp DESC")
    fun getAllRunsSortedbyDate(): LiveData<List<Run>>

    @Query("SELECT * FROM running_table ORDER BY timeInMillis DESC")
    fun getAllRunsSortedbyTimeInMillis(): LiveData<List<Run>>

    @Query("SELECT * FROM running_table ORDER BY caloriesBurned DESC")
    fun getAllRunsSortedbyCaloriesBurned(): LiveData<List<Run>>

    @Query("SELECT * FROM running_table ORDER BY averageSpeed DESC")
    fun getAllRunsSortedbyAverageSpeed(): LiveData<List<Run>>

    @Query("SELECT * FROM running_table ORDER BY distance DESC")
    fun getAllRunsSortedbyDistance(): LiveData<List<Run>>

    @Query("SELECT SUM(timeInMillis) FROM running_table")
    fun getTotalTimeInMillis(): LiveData<Long>

    @Query("SELECT SUM(caloriesBurned) FROM running_table")
    fun getTotalCaloriesBurned(): LiveData<Int>

    @Query("SELECT SUM(distance) FROM running_table")
    fun getTotalDistance(): LiveData<Int>

    @Query("SELECT AVG(averageSpeed) FROM running_table")
    fun getTotalAverageSpeed(): LiveData<Float>

}