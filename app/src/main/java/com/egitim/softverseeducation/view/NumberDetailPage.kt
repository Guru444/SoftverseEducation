package com.egitim.softverseeducation.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.egitim.softverseeducation.databinding.ActivityNumberDetailPageBinding

class NumberDetailPage : AppCompatActivity() {
    private lateinit var binding: ActivityNumberDetailPageBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNumberDetailPageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setBar(intent.getIntExtra("deger", 0))
    }
    fun setBar(sayi: Int) {
        binding.numaraBar.setProgress(sayi, true)
        if(sayi<101){
            binding.tvYuzdelik.setText("%"+sayi.toString())
        }else{
            binding.tvYuzdelik.setText("%"+(sayi%100).toString())
        }
    }
}