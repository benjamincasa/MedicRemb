package com.example.medicremb

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.provider.BaseColumns

class DBHelper(context: Context) :
    SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    companion object {
        const val DATABASE_NAME = "hospital.db"
        const val DATABASE_VERSION = 1
    }

    private val createTableQuery = """
        CREATE TABLE IF NOT EXISTS ${PacienteContract.PacienteEntry.TABLE_NAME} (
            ${BaseColumns._ID} INTEGER PRIMARY KEY,
            ${PacienteContract.PacienteEntry.COLUMN_NOMBRE} TEXT,
            ${PacienteContract.PacienteEntry.COLUMN_APELLIDO} TEXT,
            ${PacienteContract.PacienteEntry.COLUMN_EDAD} INTEGER,
            ${PacienteContract.PacienteEntry.COLUMN_GENERO} TEXT,
            ${PacienteContract.PacienteEntry.COLUMN_DIRECCION} TEXT,
            ${PacienteContract.PacienteEntry.COLUMN_ENFERMEDAD} TEXT,
            ${PacienteContract.PacienteEntry.COLUMN_FECHA_INGRESO} TEXT
        );
    """.trimIndent()

    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL(createTableQuery)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        // Aquí puedes realizar acciones específicas si hay una actualización de la base de datos
    }
}