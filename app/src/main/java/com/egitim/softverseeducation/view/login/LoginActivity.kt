package com.egitim.softverseeducation.view.login

import android.os.Bundle
import android.widget.CompoundButton
import androidx.appcompat.app.AppCompatActivity
import com.egitim.softverseeducation.databinding.ActivityLoginBinding
import com.egitim.softverseeducation.util.changeTextColor
import com.egitim.softverseeducation.util.clickEvent
import com.egitim.softverseeducation.util.merhabaDe
import com.egitim.softverseeducation.util.routing
import com.egitim.softverseeducation.util.startAnimationView
import com.egitim.softverseeducation.util.setInfo
import com.egitim.softverseeducation.util.showToast
import com.egitim.softverseeducation.util.topla
import com.egitim.softverseeducation.view.register.RegisterActivity
import com.orhanobut.hawk.Hawk

class LoginActivity : AppCompatActivity() {


    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Hawk.init(this).build()

        binding.apply {

            chBeniUnutma.setOnCheckedChangeListener(object : CompoundButton.OnCheckedChangeListener{
                override fun onCheckedChanged(p0: CompoundButton?, p1: Boolean) {
                    when(p1){
                        true ->{
                            Hawk.put("kAdi", edtFirstname.text.toString())
                            Hawk.put("kPassword", edtPassword.text.toString())
                            Hawk.put("isChecked", p1)
                        }
                        false->{
                            Hawk.deleteAll()
                        }
                    }
                }
            })

            Hawk.get<String>("kAdi")?.let {
                edtFirstname.setText(it)
            }
            Hawk.get<String>("kPassword")?.let {
                edtPassword.setText(it)
            }
            Hawk.get<Boolean>("isChecked")?.let {
                chBeniUnutma.isChecked = it
            }

            intent.getStringExtra("kAdi")?.let {
                edtFirstname.setText(it)
            }

            intent.getStringExtra("kPassword")?.let {
                edtPassword.setText(it)
            }

            "Murat".merhabaDe()
            topla(10, 20)
            tvGotoRegister.changeTextColor(this@LoginActivity)
            incToolbar.tvTitle.setInfo("Login Screen", "softverse", this@LoginActivity)
            btnLogin.startAnimationView(this@LoginActivity)
            imageview.startAnimationView(this@LoginActivity)
            tvGotoRegister.clickEvent {
                this@LoginActivity.routing(RegisterActivity::class.java)
            }
        }
    }
}
