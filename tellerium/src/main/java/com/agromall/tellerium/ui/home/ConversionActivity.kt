package com.agromall.tellerium.ui.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.agromall.tellerium.R
import com.agromall.tellerium.databinding.ActivityConversionBinding
import com.google.android.material.bottomsheet.BottomSheetBehavior

class ConversionActivity : AppCompatActivity() {
    lateinit var binding: ActivityConversionBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_conversion)
        initView()
    }

    private fun initView() {
        val bottomSheetBehavior = BottomSheetBehavior.from(binding.bottomSheet.parent)
        bottomSheetBehavior.state = BottomSheetBehavior.STATE_COLLAPSED


    }
}