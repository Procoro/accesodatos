package com.pblazquez.primera.simulacro

import android.content.ContentValues
import android.content.Context
import com.pblazquez.primera.simulacro.DatabaseHelper

class DataManager(context: Context) {
    private val dbHelper = DatabaseHelper(context)

    fun addData(
        nombre: String,
        apellidos: String,
        direccion: String,
        cp: Int,
        ciudad: String,
        provincia: String,
        telefono: Int
    ) {
        val db = dbHelper.writableDatabase

        val values = ContentValues().apply {
            put(DatabaseHelper.COLUMN_NOMBRE, nombre)
            put(DatabaseHelper.COLUMN_APELLIDOS, apellidos)
            put(DatabaseHelper.COLUMN_DIRECCION, direccion)
            put(DatabaseHelper.COLUMN_CP, cp)
            put(DatabaseHelper.COLUMN_CIUDAD, ciudad)
            put(DatabaseHelper.COLUMN_PROVINCIA, provincia)
            put(DatabaseHelper.COLUMN_TELEFONO, telefono)
        }
        db.insert(DatabaseHelper.TABLE_NAME, null, values)
        db.close()
    }

    fun getAllData(context: Context): String {
        val db = dbHelper.readableDatabase
        val cursor = db.rawQuery("SELECT * FROM ${DatabaseHelper.TABLE_NAME}", null)
        val data = StringBuilder()

        while (cursor.moveToNext()) {
            val nombre = cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_NOMBRE) + 0)
            val apellidos = cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_APELLIDOS) + 0)
            val direccion = cursor.getInt(cursor.getColumnIndex(DatabaseHelper.COLUMN_DIRECCION) + 0)
            val cp = cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_CP) + 0)
            val ciudad = cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_CIUDAD) + 0)
            val provincia = cursor.getInt(cursor.getColumnIndex(DatabaseHelper.COLUMN_PROVINCIA) + 0)
            val telefono = cursor.getInt(cursor.getColumnIndex(DatabaseHelper.COLUMN_TELEFONO) + 0)

            data.append("$nombre, ")
            data.append("$apellidos, ")
            data.append("$direccion, ")
            data.append("$cp, ")
            data.append("$ciudad, ")
            data.append("$provincia, ")
            data.append("$telefono ")
            data.append("\n")
        }

        cursor.close()
        db.close()

        if (data.isEmpty()) {
            return "No hay datos en la base de datos"
        }

        return data.toString()
    }

    fun eliminateData() {
        val db = dbHelper.writableDatabase
        db.delete(DatabaseHelper.TABLE_NAME, "", null)
    }}
