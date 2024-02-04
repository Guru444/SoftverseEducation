package com.egitim.softverseeducation.util

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Handler
import android.os.Looper
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.view.animation.CycleInterpolator
import android.view.animation.TranslateAnimation
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import androidx.core.content.ContextCompat
import com.egitim.softverseeducation.R
import com.egitim.softverseeducation.databinding.ActivityNumberDetailPageBinding
import com.egitim.softverseeducation.model.EdittextModel


fun Toolbar.setInfo(titleToolbar: String, subTitleToolbar: String, context: Context){
    with(this){
        title = titleToolbar
        subtitle = subTitleToolbar
        startAnimationView(context)
    }
}

fun ArrayList<String>.getSize() : Int{
    return this.size
}
fun String.merhabaDe() : String{
    return this
}

fun topla(sayi1: Int, sayi2: Int) : Int{
    return sayi1 + sayi2
}

fun mesaj(metin: String,context: Context){
    Toast.makeText(context,metin,Toast.LENGTH_SHORT).show()
}


fun TextView.changeTextColor(context: Context){
    with(this){
        setTextColor(ContextCompat.getColor(context, R.color.black))
    }
}

fun View.startAnimationView(context: Context){
    val animation: Animation = AnimationUtils.loadAnimation(context, R.anim.animation)
    this.startAnimation(animation)
    Handler(Looper.getMainLooper()).postDelayed({
        this.clearAnimation()
    }, 1000)
}


fun View.clickEvent(clickListener:  () -> Unit = {}){
    this.setOnClickListener {
        clickListener()
    }
}

fun Activity.routing(cls: Class<*>){
    val intent = Intent(this.applicationContext, cls)
    startActivity(intent)
    finish()
}

fun Context.showToast(msg: String){
    Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
}

fun ArrayList<EdittextModel>.emptyCheck(isEmptyClickListener: (String, EditText) -> Unit = {_,_->}){
    this.forEach { i->
        if (i.editText.text.isEmpty()){
            isEmptyClickListener(i.hataCiktisi, i.editText)
        }
    }
}

fun View.shakeError(){
    val shake = TranslateAnimation(0f, 10f, 0f, 0f)
    shake.duration = 40000
    shake.interpolator = CycleInterpolator(7f)
    this.startAnimation(shake)
}

fun View.show(){
    this.visibility = View.VISIBLE
}
fun View.gone(){
    this.visibility = View.GONE
}