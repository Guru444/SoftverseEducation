package com.egitim.softverseeducation

import KisiRoomAdapter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.room.Room
import com.egitim.softverseeducation.databinding.ActivityMainBinding
import demo_db.AppDatabase
import demo_db.User

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    var KisiRoomAdapter = KisiRoomAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val db = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java, "userdeneme15"
        ).allowMainThreadQueries().build()




        val userDao = db.userDao()


        userDao.insertAll(User(10,"Burak","Ezer"))
        userDao.insertAll(User(11,"Nur Seda","Ağgünlü"))
        var users: List<User> = userDao.getAll()
        var usersArray : ArrayList<User> = arrayListOf()
        for (user in users){
            usersArray.add(user)
        }



        binding.apply {
            rvKisiRoom.layoutManager = LinearLayoutManager(this@MainActivity,
                LinearLayoutManager.VERTICAL,false)
            rvKisiRoom.adapter = KisiRoomAdapter
            KisiRoomAdapter.setKisiList(usersArray)
        }





    }
}