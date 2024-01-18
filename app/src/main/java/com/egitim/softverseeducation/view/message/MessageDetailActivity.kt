package com.egitim.softverseeducation.view.message

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.egitim.softverseeducation.R
import com.egitim.softverseeducation.databinding.ActivityMessageDetailBinding

class MessageDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMessageDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMessageDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            tbUsername.title = intent.getStringExtra("userName") as String
        }
    }
}