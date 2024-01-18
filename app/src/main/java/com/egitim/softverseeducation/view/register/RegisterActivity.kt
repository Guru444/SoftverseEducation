package com.egitim.softverseeducation.view.register

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.EditText
import com.egitim.softverseeducation.R
import com.egitim.softverseeducation.databinding.ActivityRegisterBinding
import com.egitim.softverseeducation.model.EdittextModel
import com.egitim.softverseeducation.util.clickEvent
import com.egitim.softverseeducation.util.emptyCheck
import com.egitim.softverseeducation.util.routing
import com.egitim.softverseeducation.util.setInfo
import com.egitim.softverseeducation.util.shakeError
import com.egitim.softverseeducation.util.showToast
import com.egitim.softverseeducation.view.login.LoginActivity
import com.orhanobut.hawk.Hawk

class RegisterActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRegisterBinding

    var edittexList: ArrayList<EdittextModel> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.apply {
            incToolbar.tvTitle.setInfo("Register Screen", "softverse", this@RegisterActivity)

            tvGotoLogin.clickEvent {
                this@RegisterActivity.routing(LoginActivity::class.java)
            }

            btnRegister.clickEvent {
                if (formValidation()){
                    var intent = Intent(this@RegisterActivity, LoginActivity::class.java)
                    intent.putExtra("kAdi", edtFirstname.text.toString())
                    intent.putExtra("kPassword", edtPassword.text.toString())
                    startActivity(intent)
                    this@RegisterActivity.showToast("Kayıt Başarılı")
                }
            }
        }
    }

    fun formValidation() : Boolean{
        var hataVarmi = true

        binding.apply {
            edittexList.add(EdittextModel(edtFirstname, "Kullanıcı Adı boş bırakılamaz"))
            edittexList.add(EdittextModel(edtEmail, "Email boş bırakılmaz"))
            edittexList.add(EdittextModel(edtPassword, "Password boş Bırakılmaz"))

            edittexList.emptyCheck { msg, edittext->
                this@RegisterActivity.showToast(msg)
                edittext.shakeError()
                hataVarmi = false
            }

        }
        return hataVarmi
    }

    fun isEmptyCheck(editText: EditText) : Boolean{
        var isEmpty = false
        if (editText.text.isEmpty()){
            isEmpty = true
        }
        return isEmpty
    }


}