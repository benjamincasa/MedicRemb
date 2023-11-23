package com.example.medicremb
import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.provider.BaseColumns

class PacienteRepository(context: Context) {

    private val dbHelper = DBHelper(context)

    fun insertPaciente(paciente: Paciente) {
        val db = dbHelper.writableDatabase

        val values = ContentValues().apply {
            put(PacienteContract.PacienteEntry.COLUMN_NOMBRE, paciente.nombre)
            put(PacienteContract.PacienteEntry.COLUMN_APELLIDO, paciente.apellido)
            put(PacienteContract.PacienteEntry.COLUMN_EDAD, paciente.edad)
            put(PacienteContract.PacienteEntry.COLUMN_GENERO, paciente.genero)
            put(PacienteContract.PacienteEntry.COLUMN_DIRECCION, paciente.direccion)
            put(PacienteContract.PacienteEntry.COLUMN_ENFERMEDAD, paciente.enfermedad)
            put(PacienteContract.PacienteEntry.COLUMN_FECHA_INGRESO, paciente.fechaIngreso)
        }

        db.insert(PacienteContract.PacienteEntry.TABLE_NAME, null, values)
        db.close()
    }

    fun getPacientes(): List<Paciente> {
        val db = dbHelper.readableDatabase

        val projection = arrayOf(
            BaseColumns._ID,
            PacienteContract.PacienteEntry.COLUMN_NOMBRE,
            PacienteContract.PacienteEntry.COLUMN_APELLIDO,
            PacienteContract.PacienteEntry.COLUMN_EDAD,
            PacienteContract.PacienteEntry.COLUMN_GENERO,
            PacienteContract.PacienteEntry.COLUMN_DIRECCION,
            PacienteContract.PacienteEntry.COLUMN_ENFERMEDAD,
            PacienteContract.PacienteEntry.COLUMN_FECHA_INGRESO
        )

        val cursor: Cursor = db.query(
            PacienteContract.PacienteEntry.TABLE_NAME,
            projection,
            null,
            null,
            null,
            null,
            null
        )

        val pacientes = mutableListOf<Paciente>()

        while (cursor.moveToNext()) {
            val paciente = Paciente(
                id = cursor.getLong(cursor.getColumnIndexOrThrow(BaseColumns._ID)),
                nombre = cursor.getString(cursor.getColumnIndexOrThrow(PacienteContract.PacienteEntry.COLUMN_NOMBRE)),
                apellido = cursor.getString(cursor.getColumnIndexOrThrow(PacienteContract.PacienteEntry.COLUMN_APELLIDO)),
                edad = cursor.getInt(cursor.getColumnIndexOrThrow(PacienteContract.PacienteEntry.COLUMN_EDAD)),
                genero = cursor.getString(cursor.getColumnIndexOrThrow(PacienteContract.PacienteEntry.COLUMN_GENERO)),
                direccion = cursor.getString(cursor.getColumnIndexOrThrow(PacienteContract.PacienteEntry.COLUMN_DIRECCION)),
                enfermedad = cursor.getString(cursor.getColumnIndexOrThrow(PacienteContract.PacienteEntry.COLUMN_ENFERMEDAD)),
                fechaIngreso = cursor.getString(cursor.getColumnIndexOrThrow(PacienteContract.PacienteEntry.COLUMN_FECHA_INGRESO))
            )

            pacientes.add(paciente)
        }

        cursor.close()
        db.close()

        return pacientes
    }

    // Puedes implementar métodos para actualizar y eliminar pacientes según tus necesidades
}
