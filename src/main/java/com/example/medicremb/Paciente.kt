package com.example.medicremb

data class Paciente(
    val id: Long? = null,
    val nombre: String,
    val apellido: String,
    val edad: Int,
    val genero: String,
    val direccion: String,
    val enfermedad: String,
    val fechaIngreso: String
    )
