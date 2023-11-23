package com.example.medicremb

import android.provider.BaseColumns

    object PacienteContract {
        // Define el contenido de la tabla
        object PacienteEntry : BaseColumns {
            const val TABLE_NAME = "pacientes"
            const val COLUMN_NOMBRE = "nombre"
            const val COLUMN_APELLIDO = "apellido"
            const val COLUMN_EDAD = "edad"
            const val COLUMN_GENERO = "genero"
            const val COLUMN_DIRECCION = "direccion"
            const val COLUMN_ENFERMEDAD = "enfermedad"
            const val COLUMN_FECHA_INGRESO = "fecha_ingreso"

        }
    }
