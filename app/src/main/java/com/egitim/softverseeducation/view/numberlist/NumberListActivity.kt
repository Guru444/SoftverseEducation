package com.egitim.softverseeducation.view.numberlist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.egitim.softverseeducation.databinding.ActivityNumberListBinding
import com.egitim.softverseeducation.model.Number
import com.egitim.softverseeducation.view.numberlist.adapter.NumberListAdapter

class NumberListActivity : AppCompatActivity() {

    private lateinit var binding: ActivityNumberListBinding
    var numberAdapter = NumberListAdapter()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNumberListBinding.inflate(layoutInflater)
        setContentView(binding.root)
        var numberList: ArrayList<Number> = arrayListOf()

        for(x in 1..100){
            numberList.add(Number(x))

        }
        binding.btnSayiEkle.setOnClickListener{
            if (!numberList.contains(com.egitim.softverseeducation.model.Number(Integer.parseInt(binding.edtSayiEkle.text.toString())))){
                numberList.add(com.egitim.softverseeducation.model.Number(Integer.parseInt(binding.edtSayiEkle.text.toString())))
                numberAdapter.setNumberList(numberList)
                Toast.makeText(this,binding.edtSayiEkle.text.toString() + " eklendi",Toast.LENGTH_LONG).show()
            }else {
                Toast.makeText(this, "Aynı sayı listede bulunuyor.", Toast.LENGTH_LONG).show()
            }
        }

        binding.btnSayiAra.setOnClickListener{
            numberAdapter.setNumberList(numberList.filter { it.sayi.equals(Integer.parseInt(binding.edtSayiAra.text.toString())) } as ArrayList<Number>)
        }

        numberAdapter.itemClickListener = {
            Toast.makeText(this@NumberListActivity,(it.sayi*2).toString(),Toast.LENGTH_SHORT).show()
        }






        binding.apply {
            rvNumberList.layoutManager = LinearLayoutManager(this@NumberListActivity,LinearLayoutManager.VERTICAL,false)
            rvNumberList.adapter = numberAdapter
            numberAdapter.setNumberList(numberList)
        }
    }
}