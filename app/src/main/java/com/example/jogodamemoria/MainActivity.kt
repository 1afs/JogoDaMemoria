package com.example.jogodamemoria

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonJogar.setOnClickListener {
            val intent = Intent(this, Singleplayer4cards::class.java)
            startActivity(intent)
        }


    }
}