package com.egitim.softverseeducation.view.numberlist.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.egitim.softverseeducation.R
import com.egitim.softverseeducation.databinding.NumberItemLayoutBinding
import com.egitim.softverseeducation.model.Numara
import com.egitim.softverseeducation.util.changeTextColor

class NumberListAdapter : RecyclerView.Adapter<NumberListAdapter.NumberViewHolder>() {

    private var numberList: ArrayList<Numara> = arrayListOf()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NumberViewHolder {
        val binding = NumberItemLayoutBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return NumberViewHolder(binding)
    }

    override fun getItemCount(): Int = numberList.size

    override fun onBindViewHolder(holder: NumberViewHolder, position: Int) {
        holder.degerleriBas(numberList[position])
    }
    inner class NumberViewHolder(val binding: NumberItemLayoutBinding) : RecyclerView.ViewHolder(binding.root){
        fun degerleriBas(numara: Numara){
            binding.tvNumber.text = numara.sayi.toString()
            if (numara.sayi%2==0){
                binding.numberItemLayout.background = ContextCompat.getDrawable(binding.numberItemLayout.context, R.drawable.line_custom_blue)
            }else{
                binding.numberItemLayout.background = ContextCompat.getDrawable(binding.numberItemLayout.context, R.drawable.line_custom)
            }
        }


    }
    fun setNumberList(numberList: ArrayList<Numara>){
        this.numberList = numberList
        notifyDataSetChanged()
    }
}