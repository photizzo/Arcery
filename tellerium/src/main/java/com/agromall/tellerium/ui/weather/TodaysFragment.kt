package com.agromall.tellerium.ui.weather

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.activity.viewModels
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.agromall.presentation.state.UIState
import com.agromall.presentation.viewmodel.UsersViewModel
import com.agromall.tellerium.R
import com.agromall.tellerium.databinding.TodayFragmentBinding
import com.agromall.tellerium.util.displayWeatherIcon
import com.agromall.tellerium.util.getFormattedDate
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TodaysFragment : Fragment() {
    val usersViewModel: UsersViewModel by activityViewModels()
    lateinit var binding: TodayFragmentBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = TodayFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViewModel()
    }

    private fun initViewModel() {
        binding.locationTextView.text = usersViewModel.locationString.value
        usersViewModel.locationString.observe(viewLifecycleOwner, Observer { location ->
            binding.locationTextView.text = location
        })
        usersViewModel.getWeatherDataLiveData.observe(viewLifecycleOwner, Observer {
            when(it) {
                is UIState.Success -> {
                    val weatherData = it.body.first()
                    usersViewModel.selectedWeather.postValue(weatherData)
                    binding.dateTextView.text = weatherData.date.getFormattedDate()
                    binding.weatherTextView.text = weatherData.weatherDescription.capitalize()
                    binding.todaysTempTextView.text = "${String.format("%.2f", weatherData.feelsLike).toDouble()}°C"
                    binding.temperatureTextView.text = "${Math.round(weatherData.max)}"
                    binding.humidityTextView.text = "${weatherData.humidity}%"
                    binding.windSpeedTextView.text = "${weatherData.speed}km/hr"
                    binding.uvIndexTextView.text = "${Math.round((weatherData.max - weatherData.min) * 3.6)}"
                    binding.cloudsToday.displayWeatherIcon(weatherData.iconCode)

                }
                is UIState.Loading -> {

                }
                is UIState.Failed -> {

                }
            }
        })
    }

}