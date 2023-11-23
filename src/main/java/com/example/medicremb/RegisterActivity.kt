package com.example.medicremb

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        val tvGoLogin = findViewById<TextView>(R.id.tv_Go_Login)

        tvGoLogin.setOnClickListener{
            tvgotoLogin()

        }
    }
    private fun tvgotoLogin(){
        val i  = Intent(this, MainActivity::class.java)
        startActivity(i)
    }
}