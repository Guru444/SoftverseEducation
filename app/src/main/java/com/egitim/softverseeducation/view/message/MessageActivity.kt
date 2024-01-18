package com.egitim.softverseeducation.view.message

import android.app.AlertDialog
import android.app.TimePickerDialog
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.egitim.softverseeducation.adapter.MessageListAdapter
import com.egitim.softverseeducation.databinding.ActivityMessageBinding
import com.egitim.softverseeducation.model.Message
import com.egitim.softverseeducation.util.clickEvent
import com.egitim.softverseeducation.util.gone
import com.egitim.softverseeducation.util.show
import com.egitim.softverseeducation.util.startAnimationView
import com.orhanobut.hawk.Hawk


class MessageActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMessageBinding
    var messageListAdapter = MessageListAdapter()

    private var selectedTime = ""
    private var isFilter = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMessageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var liste: ArrayList<Message> = arrayListOf()


        binding.apply {
            val timePickerDialogListener: TimePickerDialog.OnTimeSetListener =
                TimePickerDialog.OnTimeSetListener { view, hourOfDay, minute -> // logic to properly handle
                    Toast.makeText(this@MessageActivity, minute.toString(), Toast.LENGTH_SHORT).show()
                    // the picked timings by user
                    val formattedTime: String = when {
                        hourOfDay == 0 -> {
                            if (minute < 10) {
                                "${hourOfDay + 12}:0${minute} am"
                            } else {
                                "${hourOfDay + 12}:${minute} am"
                            }
                        }

                        hourOfDay > 12 -> {
                            if (minute < 10) {
                                "${hourOfDay - 12}:0${minute} pm"
                            } else {
                                "${hourOfDay - 12}:${minute} pm"
                            }
                        }

                        hourOfDay == 12 -> {
                            if (minute < 10) {
                                "${hourOfDay}:0${minute} pm"
                            } else {
                                "${hourOfDay}:${minute} pm"
                            }
                        }

                        else -> {
                            if (minute < 10) {
                                "${hourOfDay}:${minute} am"
                            } else {
                                "${hourOfDay}:${minute} am"
                            }
                        }
                    }

                    tvSelectedTime.text = formattedTime
                    selectedTime = formattedTime

                    if (isFilter){
                        checkList(liste.filter { it.messageTime.equals(selectedTime) } as ArrayList<Message>)
                    }
                }

            btnSelectTime.clickEvent {
                isFilter = false
                val timePicker: TimePickerDialog = TimePickerDialog(
                    this@MessageActivity,
                    timePickerDialogListener,
                    12,
                    10,
                    false
                )
                timePicker.show()
            }

            Hawk.init(this@MessageActivity).build()



            ivFilter.clickEvent {
                isFilter = true
                val timePicker: TimePickerDialog = TimePickerDialog(
                    this@MessageActivity,
                    timePickerDialogListener,
                    12,
                    10,
                    false
                )
                timePicker.show()
            }

            checkList(liste)

            btnAdd.setOnClickListener {
                pgProgress.show()
                liste.add(Message(edtUsername.text.toString(), edtLastmessage.text.toString(), selectedTime))
                liste.reverse()
                Handler(Looper.getMainLooper()).postDelayed({
                    checkList(liste)
                }, 2000)
            }

            with(rvMessageList){
                layoutManager = LinearLayoutManager(this@MessageActivity, LinearLayoutManager.VERTICAL, false)
                adapter = messageListAdapter
                startAnimationView(this@MessageActivity)
            }

            messageListAdapter.removeItemCLickListener = {
                val builder = AlertDialog.Builder(this@MessageActivity)
                with(builder){
                    setTitle("Dikkat !")
                    setMessage("Silmek istediğinize emin misiniz?")
                    setNegativeButton("Hayır", null)
                    setPositiveButton("Evet") { dialogInterface, i ->
                        liste.remove(it)
                        checkList(liste)
                    }
                    show()
                }
            }

            messageListAdapter.clickItemListener = {
                val intent = Intent(this@MessageActivity, MessageDetailActivity::class.java)
                intent.putExtra("userName" ,it.userName)
                startActivity(intent)
            }
        }
    }
    fun checkList(liste: ArrayList<Message>){
        binding.apply {
            if (liste.isEmpty()){
                tvNoItem.show()
                rvMessageList.gone()
            }else{
                tvNoItem.gone()
                rvMessageList.show()
                messageListAdapter.setMessageList(liste)
                pgProgress.gone()
            }
        }
    }
}