package com.egitim.softverseeducation.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.egitim.softverseeducation.R
import com.egitim.softverseeducation.databinding.ActivityNumberDetailPageBinding

class NumberDetailPage : AppCompatActivity() {
    private lateinit var binding: ActivityNumberDetailPageBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNumberDetailPageBinding.inflate(layoutInflater)
        setContentView(binding.root)


        setBar(60)
    }
    fun setBar(sayi:Int){
        binding.numaraBar.setProgress(sayi,true)
    }
}