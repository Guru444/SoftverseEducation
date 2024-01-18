package com.egitim.softverseeducation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.egitim.softverseeducation.databinding.ActivityMain3Binding

class MainActivity3 : AppCompatActivity() {

   private lateinit var binding: ActivityMain3Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain3Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            //buttonClick(btn1, "Button1")
            //buttonClick(btn2, "Button2")
            //buttonClick(btn3, "Button3")
        }
        Toast.makeText(this, merhaba(), Toast.LENGTH_SHORT).show()
    }

    //ButtonClick handler
    fun buttonClick(button : Button, buttonName: String){
        button.setOnClickListener {
            Toast.makeText(this@MainActivity3, "Merhaba ben $buttonName", Toast.LENGTH_SHORT).show()
        }
    }

    //Return function for Merhaba Arkadaşlar messages
    fun merhaba() : String{
        return "Merhaba Arkadaşlar"
    }

}