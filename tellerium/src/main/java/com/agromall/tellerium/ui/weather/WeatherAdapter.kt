package com.agromall.tellerium.ui.weather

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.agromall.domain.model.user.WeatherData
import com.agromall.tellerium.databinding.LayoutWeatherBinding
import com.agromall.tellerium.util.displayWeatherIcon
import com.agromall.tellerium.util.getFormattedDate

class WeatherAdapter(val listener: (WeatherData) -> Unit) :
    ListAdapter<WeatherData, WeatherAdapter.ViewHolder>(WeatherDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val weather = getItem(position) as WeatherData
        holder.bind(weather, listener)
    }

    class ViewHolder private constructor(val binding: LayoutWeatherBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: WeatherData, listener: (WeatherData) -> Unit) {
            binding.descriptionTv.text = item.weatherDescription.capitalize()
            binding.weatherImage.displayWeatherIcon(item.iconCode)
            binding.dayTv.text = item.date.getFormattedDate().substringBefore(",")
            binding.degreesTv.text = "${Math.round(item.min)}°/${Math.round(item.max)}°"
            binding.parent.setOnClickListener {
                listener.invoke(item)
            }
        }

        companion object {
            fun from(parent: ViewGroup): WeatherAdapter.ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = LayoutWeatherBinding.inflate(layoutInflater, parent, false)
                return WeatherAdapter.ViewHolder(binding)
            }
        }
    }
}

class WeatherDiffCallback : DiffUtil.ItemCallback<WeatherData>() {
    override fun areItemsTheSame(oldItem: WeatherData, newItem: WeatherData): Boolean {
        return oldItem.date == newItem.date
    }

    override fun areContentsTheSame(oldItem: WeatherData, newItem: WeatherData): Boolean {
        return oldItem.date == newItem.date
    }
}
