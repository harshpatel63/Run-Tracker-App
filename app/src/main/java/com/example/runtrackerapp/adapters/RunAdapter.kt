package com.example.runtrackerapp.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.runtrackerapp.R
import com.example.runtrackerapp.other.TrackingUtil
import com.example.runtrackerapp.roomDB.entities.Run
import com.google.android.material.textview.MaterialTextView
import java.text.SimpleDateFormat
import java.util.*

class RunAdapter : RecyclerView.Adapter<RunAdapter.RunViewHolder>() {

    inner class RunViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){

    }

    val diffCallback = object : DiffUtil.ItemCallback<Run>() {
        override fun areItemsTheSame(oldItem: Run, newItem: Run): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Run, newItem: Run): Boolean {
           return oldItem.hashCode() == newItem.hashCode()
        }
    }

    val differ = AsyncListDiffer(this, diffCallback)

    fun submitList(list: List<Run>) = differ.submitList(list)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RunViewHolder {
        return RunViewHolder(
                LayoutInflater.from(parent.context).inflate(
                        R.layout.item_run,
                        parent,
                        false
                )
        )
    }

    override fun onBindViewHolder(holder: RunViewHolder, position: Int) {
        val currentItem = differ.currentList[position]
        holder.itemView.apply {
            Glide.with(this).load(currentItem.img).into(findViewById(R.id.ivRunImage))


            val calender = Calendar.getInstance().apply {
                timeInMillis = currentItem.timestamp
            }
            val dateFormat = SimpleDateFormat("dd.MM.yy", Locale.getDefault())
            findViewById<MaterialTextView>(R.id.tvDate).text = dateFormat.format(calender.time)

            val avgSpeed = "${currentItem.averageSpeed}km/h"
            findViewById<MaterialTextView>(R.id.tvAvgSpeed).text = avgSpeed

            val distanceInKm = "${currentItem.distance / 1000f}"
            findViewById<MaterialTextView>(R.id.tvDistance).text = distanceInKm

            findViewById<MaterialTextView>(R.id.tvTime).text = TrackingUtil.getFormattedStopWatchTime(currentItem.timeInMillis)

            val caloriesBurned = "${currentItem.caloriesBurned}kcal"
            findViewById<MaterialTextView>(R.id.tvCalories).text = caloriesBurned
        }
    }

    override fun getItemCount(): Int = differ.currentList.size

}