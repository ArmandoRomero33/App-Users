package com.app.userssp

import android.content.Context
import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.app.userssp.databinding.ActivityMainBinding
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity(), OnClickListener {

    private lateinit var userAdapter: UserAdapter
    private lateinit var linearLayoutManager: RecyclerView.LayoutManager

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val preferences = getPreferences(Context.MODE_PRIVATE)

        val isFirstTime = preferences.getBoolean(getString(R.string.sp_first_time), true)
        Log.i("SP", "${getString(R.string.sp_first_time)} = $isFirstTime")

        if(isFirstTime) {
            val dialogView = layoutInflater.inflate(R.layout.dialog_register, null)

            MaterialAlertDialogBuilder(this)
                .setTitle(R.string.dialog_title)
                .setView(dialogView)
                .setCancelable(false)
                .setPositiveButton(R.string.dialog_confirm, { dialogInterface, i ->
                    val username = dialogView.findViewById<TextInputEditText>(R.id.etUsername)
                        .text.toString()
                    with(preferences.edit()){
                        putBoolean(getString(R.string.sp_first_time), false)
                        putString(getString(R.string.sp_username), username)
                            .apply()
                    }
                    Toast.makeText(this, R.string.register_succes, Toast.LENGTH_SHORT)
                        .show()
                })
                .show()
        } else{
            val username = preferences.getString(getString(R.string.sp_username), getString(R.string.helper_username))
            Toast.makeText(this, "Bienvenido $username", Toast.LENGTH_SHORT).show()
        }

        userAdapter = UserAdapter(getUsers(), this )
        linearLayoutManager = LinearLayoutManager(this)

        binding.recycleView.apply {
            setHasFixedSize(true)
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

    override fun onClick(user: User, position: Int) {
        Toast.makeText(this, "$position: ${ user.getFullName()}", Toast.LENGTH_SHORT).show()
    }

}