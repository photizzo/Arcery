package com.agromall.tellerium.ui.weather

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.agromall.presentation.viewmodel.UsersViewModel
import com.agromall.tellerium.R
import com.agromall.tellerium.util.getFormattedDate
import com.agromall.tellerium.util.showSnackbar
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ShareFragment : Fragment() {
    val usersViewModel: UsersViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.share_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (usersViewModel.selectedWeather.value == null) {
            activity?.showSnackbar("No weather data available to share")
        } else {
            share(
                "${usersViewModel.selectedWeather.value!!.date.getFormattedDate()} - ${usersViewModel.selectedWeather.value!!.weatherDescription} @ ${Math.round(
                    usersViewModel.selectedWeather.value!!.feelsLike
                )}°C from: Arcery"
            )

        }
    }

    private fun share(message: String) {
        val sendIntent: Intent = Intent().apply {
            action = Intent.ACTION_SEND
            putExtra(Intent.EXTRA_TEXT, message)
            type = "text/plain"
        }

        val shareIntent = Intent.createChooser(sendIntent, null)
        startActivity(shareIntent)
    }
}