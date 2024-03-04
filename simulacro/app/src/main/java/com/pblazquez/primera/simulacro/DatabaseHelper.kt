package com.pblazquez.primera.simulacro

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DatabaseHelper(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    companion object {
        private const val DATABASE_VERSION = 1
        private const val DATABASE_NAME = "empresa"
        const val TABLE_NAME = "datospersonales"
        const val COLUMN_ID = "_id"
        const val COLUMN_NOMBRE = "nombre"
        const val COLUMN_APELLIDOS = "apellidos"
        const val COLUMN_DIRECCION = "direccion"
        const val COLUMN_CP = "cp"
        const val COLUMN_CIUDAD = "ciudad"
        const val COLUMN_PROVINCIA = "provincia"
        const val COLUMN_TELEFONO = "telefono"
    }

    override fun onCreate(db: SQLiteDatabase) {
        val CREATE_TABLE = "CREATE TABLE $TABLE_NAME" +
                "($COLUMN_ID INTEGER PRIMARY KEY, $COLUMN_NOMBRE TEXT, $COLUMN_APELLIDOS TEXT," +
                " $COLUMN_DIRECCION TEXT, $COLUMN_CP INTEGER(5)," +
                " $COLUMN_CIUDAD TEXT, $COLUMN_PROVINCIA TEXT, $COLUMN_TELEFONO INTEGER(9))"
        db.execSQL(CREATE_TABLE)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("DROP TABLE IF EXISTS $TABLE_NAME")
        onCreate(db)
    }

}
