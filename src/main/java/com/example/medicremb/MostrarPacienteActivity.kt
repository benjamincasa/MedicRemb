package com.example.medicremb

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MostrarPacienteActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mostrar_paciente)

val btncancelar = findViewById<Button>(R.id.btn_cancelar)
        btncancelar.setOnClickListener {
            Regresarmenu()
        }
    }
    private fun Regresarmenu(){
    val intent = Intent(this, MenuActivity::class.java)
    startActivity(intent)
    finish()
    }
}