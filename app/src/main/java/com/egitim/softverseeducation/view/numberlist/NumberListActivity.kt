package com.egitim.softverseeducation.view.numberlist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.egitim.softverseeducation.R
import com.egitim.softverseeducation.databinding.ActivityNumberListBinding

class NumberListActivity : AppCompatActivity() {

    private lateinit var binding: ActivityNumberListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNumberListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {

        }
    }
}