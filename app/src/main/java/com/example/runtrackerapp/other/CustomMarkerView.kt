package com.example.runtrackerapp.other

import android.content.Context
import com.example.runtrackerapp.R
import com.example.runtrackerapp.roomDB.entities.Run
import com.github.mikephil.charting.components.MarkerView
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.highlight.Highlight
import com.github.mikephil.charting.utils.MPPointF
import com.google.android.material.textview.MaterialTextView
import java.text.SimpleDateFormat
import java.util.*

class CustomMarkerView(
        val runs: List<Run>,
        context: Context,
        layoutId: Int
): MarkerView(context, layoutId) {

    override fun getOffset(): MPPointF {
        return MPPointF(-width / 2f, -height.toFloat())

    }

    override fun refreshContent(e: Entry?, highlight: Highlight?) {
        super.refreshContent(e, highlight)
        if(e == null) {
            return
        }
        val curRunId = e.x.toInt()
        val currentItem = runs[curRunId]

        val calender = Calendar.getInstance().apply {
            timeInMillis = currentItem.timestamp
        }
        val dateFormat = SimpleDateFormat("dd.MM.yy", Locale.getDefault())
        findViewById<MaterialTextView>(R.id.tvDateM).text = dateFormat.format(calender.time)

        val avgSpeed = "${currentItem.averageSpeed}km/h"
        findViewById<MaterialTextView>(R.id.tvAvgSpeedM).text = avgSpeed

        val distanceInKm = "${currentItem.distance / 1000f}"
        findViewById<MaterialTextView>(R.id.tvDistanceM).text = distanceInKm

        findViewById<MaterialTextView>(R.id.tvDuration).text = TrackingUtil.getFormattedStopWatchTime(currentItem.timeInMillis)

        val caloriesBurned = "${currentItem.caloriesBurned}kcal"
        findViewById<MaterialTextView>(R.id.tvCaloriesBurned).text = caloriesBurned

    }
}