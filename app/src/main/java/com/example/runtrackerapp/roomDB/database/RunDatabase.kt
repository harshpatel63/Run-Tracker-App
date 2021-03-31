package com.example.runtrackerapp.roomDB.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.runtrackerapp.roomDB.Converters
import com.example.runtrackerapp.roomDB.dao.RunDao
import com.example.runtrackerapp.roomDB.entities.Run

@Database(entities = [Run::class], version = 1, exportSchema = false)
@TypeConverters(Converters::class)
abstract class RunDatabase : RoomDatabase() {

    abstract fun getRunDao(): RunDao

}