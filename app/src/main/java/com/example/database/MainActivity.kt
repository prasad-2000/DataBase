package com.example.database

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        add.setOnClickListener {
            val i =Intent(this,addEmployee::class.java)
            startActivity(i)
        }
        delete.setOnClickListener {
            val i = Intent(this,deleteEmployee::class.java)
            startActivity(i)
        }
        display3.setOnClickListener {
            val i =Intent(this,DisplayEmployee::class.java)
            startActivity(i)
        }
        update.setOnClickListener {
            val i = Intent(this,updateEmployee::class.java)
            startActivity(i)
        }

    }
}