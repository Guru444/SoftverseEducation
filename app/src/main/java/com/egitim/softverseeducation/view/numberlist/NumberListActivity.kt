package com.egitim.softverseeducation.view.numberlist

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.egitim.softverseeducation.databinding.ActivityNumberListBinding
import com.egitim.softverseeducation.model.Number
import com.egitim.softverseeducation.util.mesaj
import com.egitim.softverseeducation.view.NumberDetailPage
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
            if(binding.edtSayiEkle.text.toString().isEmpty()){
                mesaj("Boş bırakılamaz",this)
            }
            else if (!numberList.contains(com.egitim.softverseeducation.model.Number(Integer.parseInt(binding.edtSayiEkle.text.toString())))){
                numberList.add(com.egitim.softverseeducation.model.Number(Integer.parseInt(binding.edtSayiEkle.text.toString())))
                numberAdapter.setNumberList(numberList)
                mesaj(binding.edtSayiEkle.text.toString() + " eklendi",this)
            }else {
                mesaj("Aynı sayı listede bulunuyor.",this)
            }
        }

        binding.btnSayiAra.setOnClickListener{
            if(binding.edtSayiAra.text.toString().isEmpty()){
                mesaj("Boş bırakılamaz",this)
            }else{
                numberAdapter.setNumberList(numberList.filter { it.sayi.equals(Integer.parseInt(binding.edtSayiAra.text.toString())) } as ArrayList<Number>)
            }
        }

        numberAdapter.itemClickListener = {
            mesaj(("Sayı iki katı : " + it.sayi*2).toString(),this)
            intent = Intent(this,NumberDetailPage::class.java)
            intent.putExtra("deger",it.sayi)
            startActivity(intent)
        }

        binding.apply {
            rvNumberList.layoutManager = LinearLayoutManager(this@NumberListActivity,LinearLayoutManager.VERTICAL,false)
            rvNumberList.adapter = numberAdapter
            numberAdapter.setNumberList(numberList)
        }
    }
}