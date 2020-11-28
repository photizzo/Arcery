package com.agromall.tellerium.ui.weather

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import com.agromall.domain.model.user.WeatherData
import com.agromall.presentation.state.UIState
import com.agromall.presentation.viewmodel.UsersViewModel
import com.agromall.tellerium.R
import com.agromall.tellerium.databinding.WeeklyFragmentBinding
import com.agromall.tellerium.util.displayWeatherIcon
import com.agromall.tellerium.util.getFormattedDate
import com.google.android.material.appbar.AppBarLayout
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class WeeklyFragment : Fragment() {
    val usersViewModel: UsersViewModel by activityViewModels()
    lateinit var binding: WeeklyFragmentBinding
    lateinit var adapter: WeatherAdapter
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = WeeklyFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter = WeatherAdapter() {
            displayWeatherData(it)
        }
        binding.weeklyFragment.weatherList.adapter = adapter
        binding.weeklyFragment.weatherList.addItemDecoration(
            DividerItemDecoration(
                this.context,
                DividerItemDecoration.VERTICAL
            )
        )

        initViewModel()
    }

    private fun initViewModel() {
        binding.locationTextView.text = usersViewModel.locationString.value
        usersViewModel.locationString.observe(viewLifecycleOwner, Observer { location ->
            binding.locationTextView.text = location
        })
        val state = usersViewModel.getWeatherDataLiveData.value
        if (state is UIState.Success && state.body != null) {
            displayWeatherData(state.body.first())
            adapter.submitList(state.body)
        }
        usersViewModel.getWeatherDataLiveData.observe(viewLifecycleOwner, Observer {
            when (it) {
                is UIState.Success -> {
                    val weatherData = it.body.first()
                    displayWeatherData(weatherData)
                    adapter.submitList(it.body)
                }
                is UIState.Loading -> {

                }
                is UIState.Failed -> {

                }
            }
        })
    }

    private fun displayWeatherData(weatherData: WeatherData) {
        binding.dateTextView.text = weatherData.date.getFormattedDate()
//        binding.appBarLayout.addOnOffsetChangedListener(AppBarLayout.OnOffsetChangedListener { appBarLayout, verticalOffset ->
//            if (Math.abs(verticalOffset) == binding.appBarLayout.totalScrollRange) {
//                // Collapsed
//                binding.toolbar.title = weatherData.date.getFormattedDate()
//            } else if (verticalOffset == 0) {
//                // Expanded
//                binding.toolbar.title = ""
//            } else {
//                // Somewhere in between
//                binding.toolbar.title = ""
//            }
//        })
        binding.weatherTextView.text = weatherData.weatherDescription.capitalize()
        binding.temperatureTextView.text = "${Math.round(weatherData.max)}"
        binding.cloudsToday.displayWeatherIcon(weatherData.iconCode)
        usersViewModel.selectedWeather.postValue(weatherData)
    }
}