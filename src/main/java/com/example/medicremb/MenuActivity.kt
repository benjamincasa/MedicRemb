package com.example.medicremb

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.medicremb.util.PreferenceHelper
import com.example.medicremb.util.PreferenceHelper.set


class MenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        val btnlogout = findViewById<Button>(R.id.btn_logout)
        btnlogout.setOnClickListener {
            goToLogin()

        }
        val btnagregarpa = findViewById<Button>(R.id.btn_agregarpaciente)
        btnagregarpa.setOnClickListener {
            agregarpaciente()

        }
        val btnmostraspaciente = findViewById<Button>(R.id.btn_mostrarpacientes)
        btnmostraspaciente.setOnClickListener {
            mostrarpacientes()
        }
    }

    private fun mostrarpacientes(){
        var i = Intent(this,MostrarPacienteActivity::class.java)
        startActivity(i)
        finish()
    }

    private fun agregarpaciente() {
        var i = Intent(this, AgregarPacienteActivity::class.java)
        startActivity(i)
        finish()

    }

    private fun goToLogin() {
        val i = Intent(this, MainActivity::class.java)
        clearSessionPreference()
        startActivity(i)
        finish()
    }

    private fun clearSessionPreference() {
        val preferences = PreferenceHelper.defaultPrefs(this)
        preferences["session"] = false
    }
}