package com.example.runtrackerapp.roomDB.entities

import android.graphics.Bitmap
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "running_table")
data class Run (
    var img: ByteArray? = null,
    var timestamp: Long = 0L,
    var averageSpeed: Float = 0f,
    var distance: Int = 0,
    var timeInMillis: Long = 0L,
    var caloriesBurned: Int = 0
) {
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null
}