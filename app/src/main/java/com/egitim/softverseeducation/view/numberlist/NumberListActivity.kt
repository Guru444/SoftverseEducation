package com.egitim.softverseeducation.view.numberlist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.egitim.softverseeducation.databinding.ActivityNumberListBinding
import com.egitim.softverseeducation.model.Numara
import com.egitim.softverseeducation.view.numberlist.adapter.NumberListAdapter

class NumberListActivity : AppCompatActivity() {

    private lateinit var binding: ActivityNumberListBinding
    var NumaraAdapter = NumberListAdapter()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNumberListBinding.inflate(layoutInflater)
        setContentView(binding.root)
        var numaraList: ArrayList<Numara> = arrayListOf()

        for(x in 1..100){
            numaraList.add(Numara(x))
        }



        binding.apply {
            rvNumberList.layoutManager = LinearLayoutManager(this@NumberListActivity,LinearLayoutManager.VERTICAL,false)
            rvNumberList.adapter = NumaraAdapter
            NumaraAdapter.setNumberList(numaraList)
        }
    }
}