package com.app.userssp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.app.userssp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var userAdapter: UserAdapter
    private lateinit var linearLayoutManager: RecyclerView.LayoutManager

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        userAdapter = UserAdapter(getUsers() )
        linearLayoutManager = LinearLayoutManager(this)

        binding.recycleView.apply {
            layoutManager = linearLayoutManager
            adapter = userAdapter
        }
    }

    private fun getUsers(): MutableList<User>{
        val users = mutableListOf<User>()

        val armando = User(1,"Armando", "Romero", "https://play.google.com/store/apps/details?id=com.innersloth.spacemafia&hl=es_MX&gl=US")
        val salma = User(2, "Salma", "Hernandez", "https://upload.wikimedia.org/wikipedia/commons/b/b2/Samanta_villar.jpg")
        val javier = User(3, "Javier", "Gómez", "https://live.staticflickr.com/974/42098804942_b9ce35b1c8_b.jpg")
        val emma = User(4, "Emma", "Cruz", "https://upload.wikimedia.org/wikipedia/commons/d/d9/Emma_Wortelboer_%282018%29.jpg")



        users.add(armando)
        users.add(salma )
        users.add(javier)
        users.add(emma)
        users.add(armando)
        users.add(salma)
        users.add(javier)
        users.add(emma)
        users.add(armando)
        users.add(salma)
        users.add(javier)
        users.add(emma)
        users.add(armando)
        users.add(salma)
        users.add(javier)
        users.add(emma)

        return users
    }

}