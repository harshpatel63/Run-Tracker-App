package com.example.runtrackerapp.roomDB.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.runtrackerapp.roomDB.dao.RunDao
import com.example.runtrackerapp.roomDB.entities.Run

@Database(entities = [Run::class], version = 1, exportSchema = false)
abstract class RunDatabase : RoomDatabase() {

    abstract fun getRunDao(): RunDao

}