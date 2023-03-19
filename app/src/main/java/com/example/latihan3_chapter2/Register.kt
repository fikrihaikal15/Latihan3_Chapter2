package com.example.latihan3_chapter2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.latihan3_chapter2.databinding.ActivityRegisterBinding

private lateinit var binding : ActivityRegisterBinding

class Register : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btn1.setOnClickListener {
            startActivity(Intent(this,Home::class.java))
        }
        binding.tv2.setOnClickListener {
            startActivity(Intent(this,Home::class.java))
        }
    }
}