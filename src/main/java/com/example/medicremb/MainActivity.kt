package com.example.medicremb

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.medicremb.util.PreferenceHelper
import com.example.medicremb.util.PreferenceHelper.get
import com.example.medicremb.util.PreferenceHelper.set

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val  preferences = PreferenceHelper.defaultPrefs(this)
        if (preferences["session",false])
            goToMenu()

        val tvGoRegister = findViewById<Button>(R.id.tv_Go_Register)
        tvGoRegister.setOnClickListener{
            goToRegister()
        }
        val btnToMenu = findViewById<Button>(R.id.btn_go_to_menu)
        btnToMenu.setOnClickListener{
            goToMenu()
        }
    }
    private fun goToRegister(){
        var i = Intent (this,RegisterActivity::class.java)
        startActivity(i)
    }
    private fun goToMenu () {
        val i = Intent(this,MenuActivity::class.java)
        crateSessionPreference()
        startActivity(i)
        finish()
    }
    private fun crateSessionPreference(){
        val preferences = PreferenceHelper.defaultPrefs(this)
        preferences["session"] = true
    }

}