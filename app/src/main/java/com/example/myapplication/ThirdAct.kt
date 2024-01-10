package com.example.myapplication

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class ThirdAct : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)


        val bundle = intent.extras


        if (bundle != null && bundle.containsKey("resultText")) {
            val resultText = bundle.getString("resultText")
            val textViewResultSecond = findViewById<TextView>(R.id.textViewResultSecond)
            textViewResultSecond.text = resultText
        }

        val tombol = findViewById<Button>(R.id.tombolkembali)

        tombol.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}

